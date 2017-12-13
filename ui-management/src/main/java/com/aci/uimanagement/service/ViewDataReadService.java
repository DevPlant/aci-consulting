package com.aci.uimanagement.service;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aci.uimanagement.database.model.AccordionDatabaseModel;
import com.aci.uimanagement.database.model.AccordionGroupDatabaseModel;
import com.aci.uimanagement.database.model.DataGridDatabaseModel;
import com.aci.uimanagement.database.model.FieldDatabaseModel;
import com.aci.uimanagement.database.model.GridDatabaseModel;
import com.aci.uimanagement.database.model.LinkageDatabaseModel;
import com.aci.uimanagement.database.model.OverrideElementDatabaseModel;
import com.aci.uimanagement.database.model.OverrideElementValueDatabaseModel;
import com.aci.uimanagement.database.model.OverrideElementValueViewDatabaseModel;
import com.aci.uimanagement.database.model.PanelDatabaseModel;
import com.aci.uimanagement.database.model.TabDatabaseModel;
import com.aci.uimanagement.database.model.TabGroupDatabaseModel;
import com.aci.uimanagement.database.model.ViewElementDatabaseModel;
import com.aci.uimanagement.database.model.ViewFragmentDatabaseModel;
import com.aci.uimanagement.model.ViewFragment;
import com.aci.uimanagement.model.common.AbstractViewElement;
import com.aci.uimanagement.model.elements.Accordion;
import com.aci.uimanagement.model.elements.AccordionGroup;
import com.aci.uimanagement.model.elements.DataGrid;
import com.aci.uimanagement.model.elements.Field;
import com.aci.uimanagement.model.elements.Grid;
import com.aci.uimanagement.model.elements.Panel;
import com.aci.uimanagement.model.elements.Tab;
import com.aci.uimanagement.model.elements.TabGroup;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ViewDataReadService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlService sqlService;

    private QueryRunner queryRunner;

    @PostConstruct
    protected void postConstruct() {
        queryRunner = new QueryRunner(dataSource);
    }

    public ViewFragment readView(String viewName) throws InvocationTargetException, IllegalAccessException, SQLException, InstantiationException {


        // Load the desired viewFragment
        ViewFragmentDatabaseModel viewFragmentDatabaseModel = getSingleObject(ViewFragmentDatabaseModel.class,
                sqlService.createSelectAllStatement(ViewFragmentDatabaseModel.TABLE_NAME) + " WHERE " + ViewFragmentDatabaseModel.NAME_COLUMN + " = ?", viewName);

        // Load all view elements, tabs, fields, grids, etc...
        List<FieldDatabaseModel> databaseFields = getList(FieldDatabaseModel.class, getViewElementsQuery(FieldDatabaseModel.TABLE_NAME, FieldDatabaseModel.VIEW_ELEMENT_ID_COLUMN));
        List<TabGroupDatabaseModel> databaseTabGroups = getList(TabGroupDatabaseModel.class, getViewElementsQuery(TabGroupDatabaseModel.TABLE_NAME, TabGroupDatabaseModel.VIEW_ELEMENT_ID_COLUMN));
        List<AccordionGroupDatabaseModel> databaseAccordionGrups = getList(AccordionGroupDatabaseModel.class, getViewElementsQuery(AccordionGroupDatabaseModel.TABLE_NAME, AccordionGroupDatabaseModel.VIEW_ELEMENT_ID_COLUMN));
        List<GridDatabaseModel> databaseGrids = getList(GridDatabaseModel.class, getViewElementsQuery(GridDatabaseModel.TABLE_NAME, GridDatabaseModel.VIEW_ELEMENT_ID_COLUMN));
        List<DataGridDatabaseModel> databaseDataGrids = getList(DataGridDatabaseModel.class, getViewElementsQuery(DataGridDatabaseModel.TABLE_NAME, DataGridDatabaseModel.VIEW_ELEMENT_ID_COLUMN));
        List<PanelDatabaseModel> databasePanels = getList(PanelDatabaseModel.class, getViewElementsQuery(PanelDatabaseModel.TABLE_NAME, PanelDatabaseModel.VIEW_ELEMENT_ID_COLUMN));
        List<TabDatabaseModel> databaseTabs = getList(TabDatabaseModel.class, getViewElementsQuery(TabDatabaseModel.TABLE_NAME, TabDatabaseModel.VIEW_ELEMENT_ID_COLUMN));
        List<AccordionDatabaseModel> databaseAccordions = getList(AccordionDatabaseModel.class, getViewElementsQuery(AccordionDatabaseModel.TABLE_NAME, AccordionDatabaseModel.VIEW_ELEMENT_ID_COLUMN));

        // Load links between the elements
        List<LinkageDatabaseModel> databaseLinks = getList(LinkageDatabaseModel.class,
                sqlService.createSelectAllStatement(LinkageDatabaseModel.TABLE_NAME) + " WHERE " + LinkageDatabaseModel.VIEW_FRAGMENT_ID_COLUMN + " = ? ", viewFragmentDatabaseModel.getId());

        // Load OverrideElements and their values joined together
        List<OverrideElementValueViewDatabaseModel> overrideElements = getList(OverrideElementValueViewDatabaseModel.class,
                sqlService.createSelectAllStatement(OverrideElementDatabaseModel.TABLE_NAME) + " INNER JOIN " + OverrideElementValueDatabaseModel.TABLE_NAME
                        + " ON " + OverrideElementDatabaseModel.TABLE_NAME + "." + OverrideElementDatabaseModel.ID_COLUMN + " = " + OverrideElementValueDatabaseModel.TABLE_NAME + "." + OverrideElementValueDatabaseModel.OVERRIDE_ELEMENT_ID_COLUMN
                        + " WHERE " + OverrideElementDatabaseModel.VIEW_FRAGMENT_ID_COLUMN + " = ? ", viewFragmentDatabaseModel.getId());


        // Create the ViewFragment
        ViewFragment viewFragment = new ViewFragment();
        // Copy Properties from the databaseModel
        BeanUtils.copyProperties(viewFragment, viewFragmentDatabaseModel);

        // Add all elements to a map, so we can access them quickly, use their actual types!
        Map<Long, AbstractViewElement> quickAccessMap = new HashMap<>();
        convertAndAddToQuickAccessMap(databasePanels, Panel.class, quickAccessMap);
        convertAndAddToQuickAccessMap(databaseTabs, Tab.class, quickAccessMap);
        convertAndAddToQuickAccessMap(databaseTabGroups, TabGroup.class, quickAccessMap);
        convertAndAddToQuickAccessMap(databaseAccordions, Accordion.class, quickAccessMap);
        convertAndAddToQuickAccessMap(databaseAccordionGrups, AccordionGroup.class, quickAccessMap);
        convertAndAddToQuickAccessMap(databaseFields, Field.class, quickAccessMap);
        convertAndAddToQuickAccessMap(databaseGrids, Grid.class, quickAccessMap);
        convertAndAddToQuickAccessMap(databaseDataGrids, DataGrid.class, quickAccessMap);

        // Override the elements properties using the overrideValues
        overrideElements.stream().sorted().forEach(overrideElement -> overrideElement.updateProperty(quickAccessMap.get(overrideElement.getElementId())));

        // Compute the hierarchical view model
        Map<Long, List<Long>> elementStructure = new HashMap<>();
        databaseLinks.forEach(link -> elementStructure.computeIfAbsent(link.getViewElementParentId(), k -> new ArrayList<>()).add(link.getViewElementId()));

        elementStructure.get(null).forEach(viewChildId -> viewFragment.getChildren().add(quickAccessMap.get(viewChildId)));
        viewFragment.getChildren().forEach(child -> updateChildElements(child, elementStructure, quickAccessMap));

        viewFragment.sortChildren();

        return viewFragment;
    }

    private <T extends AbstractViewElement, S> void convertAndAddToQuickAccessMap(List<S> sourceList, Class<T> targetClass, Map<Long, AbstractViewElement> quickAccessMap) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (S source : sourceList) {
            T target = targetClass.newInstance();
            BeanUtils.copyProperties(target, source);
            quickAccessMap.put(target.getViewElementId(), target);
        }
    }


    private <T> List<T> getList(Class<T> clazz, String query, Object... queryParameters) throws SQLException {
        ResultSetHandler<List<T>> beanListHandler = new BeanListHandler<>(clazz, new BasicRowProcessor(new GenerousBeanProcessor()));
        log.info("Executing query: {}", query);
        return queryRunner.query(query, beanListHandler, queryParameters);
    }

    private <T> T getSingleObject(Class<T> clazz, String query, Object... queryParameters) throws SQLException {
        ResultSetHandler<T> beanHandler = new BeanHandler<>(clazz, new BasicRowProcessor(new GenerousBeanProcessor()));
        log.info("Executing query: {}", query);
        return queryRunner.query(query, beanHandler, queryParameters);
    }

    private String getViewElementsQuery(String elementTableName, String elementIdColumn) {
        return sqlService.createSelectAllStatement(ViewElementDatabaseModel.TABLE_NAME) +
                " INNER JOIN " + elementTableName + " ON " + elementTableName + "." + elementIdColumn + " = " + ViewElementDatabaseModel.TABLE_NAME + "." + ViewElementDatabaseModel.ID_COLUMN;
    }

    // Recursion to build viewFragment
    private void updateChildElements(AbstractViewElement currentElement, Map<Long, List<Long>> elementStructure, Map<Long, AbstractViewElement> quickAccessMap) {
        if (currentElement != null) {
            List<Long> viewChildIds = elementStructure.get(currentElement.getViewElementId());

            if (viewChildIds != null) {
                for (Long viewChildId : viewChildIds) {
                    AbstractViewElement childElement = quickAccessMap.get(viewChildId);
                    if (!currentElement.getChildren().contains(childElement)) {
                        currentElement.getChildren().add(childElement);
                    }
                    updateChildElements(childElement, elementStructure, quickAccessMap);
                }
            }
        }

    }

}
