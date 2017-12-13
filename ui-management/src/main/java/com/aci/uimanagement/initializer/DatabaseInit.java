package com.aci.uimanagement.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.aci.uimanagement.initializer.entity.AccordionEntity;
import com.aci.uimanagement.initializer.entity.AccordionGroupEntity;
import com.aci.uimanagement.initializer.entity.DataGridEntity;
import com.aci.uimanagement.initializer.entity.FieldEntity;
import com.aci.uimanagement.initializer.entity.GridEntity;
import com.aci.uimanagement.initializer.entity.LinkageEntity;
import com.aci.uimanagement.initializer.entity.OverrideElementEntity;
import com.aci.uimanagement.initializer.entity.OverrideElementValueEntity;
import com.aci.uimanagement.initializer.entity.PanelEntity;
import com.aci.uimanagement.initializer.entity.TabEntity;
import com.aci.uimanagement.initializer.entity.TabGroupEntity;
import com.aci.uimanagement.initializer.entity.ViewElementEntity;
import com.aci.uimanagement.initializer.entity.ViewFragmentEntity;
import com.aci.uimanagement.initializer.repository.LinkageRepository;
import com.aci.uimanagement.initializer.repository.OverrideElementRepository;
import com.aci.uimanagement.initializer.repository.OverrideElementValueRepository;
import com.aci.uimanagement.initializer.repository.ViewElementRepository;
import com.aci.uimanagement.initializer.repository.ViewFragmentRepository;
import com.aci.uimanagement.model.types.ElementType;
import com.aci.uimanagement.model.types.FieldRendererType;
import com.aci.uimanagement.model.types.FieldType;
import com.aci.uimanagement.model.types.LayoutType;
import com.aci.uimanagement.model.types.OverrideType;
import com.aci.uimanagement.model.types.PropertyType;

@Service
public class DatabaseInit implements CommandLineRunner {

    @Autowired
    private ViewFragmentRepository viewFragmentRepository;

    @Autowired
    private ViewElementRepository viewElementRepository;

    @Autowired
    private LinkageRepository linkageRepository;

    @Autowired
    private OverrideElementRepository overrideElementRepository;

    @Autowired
    private OverrideElementValueRepository overrideElementValueRepository;

    @Override
    public void run(String... strings) throws Exception {

        ViewFragmentEntity viewFragment1 = new ViewFragmentEntity();
        viewFragment1.setLayoutType(LayoutType.COLUMN);
        viewFragment1.setName("view1");

        viewFragment1 = viewFragmentRepository.save(viewFragment1);


        ViewElementEntity tab1GroupElement = new ViewElementEntity();

        tab1GroupElement.setElementType(ElementType.TAB_GROUP);

        TabGroupEntity tab1Group = new TabGroupEntity();
        tab1Group.setViewElement(tab1GroupElement);
        tab1GroupElement.setTabGroupEntity(tab1Group);
        tab1GroupElement = viewElementRepository.save(tab1GroupElement);


        ViewElementEntity tab1Element = new ViewElementEntity();

        tab1Element.setElementType(ElementType.TAB);


        TabEntity tab1 = new TabEntity();
        tab1.setViewElement(tab1Element);
        tab1.setLabelTranslationKey("tab1.translation.key");
        tab1.setName("Tab 1");
        tab1.setLayoutType(LayoutType.ROW);
        tab1Element.setTabEntity(tab1);
        tab1Element = viewElementRepository.save(tab1Element);

        ViewElementEntity tab2Element = new ViewElementEntity();

        tab2Element.setElementType(ElementType.TAB);


        TabEntity tab2 = new TabEntity();
        tab2.setViewElement(tab2Element);
        tab2.setLabelTranslationKey("tab2.translation.key");
        tab2.setName("Tab 2");
        tab2.setLayoutType(LayoutType.COLUMN);
        tab2Element.setTabEntity(tab2);
        tab2Element = viewElementRepository.save(tab2Element);


        ViewElementEntity panel1Element = new ViewElementEntity();

        panel1Element.setElementType(ElementType.PANEL);

        PanelEntity panel1 = new PanelEntity();
        panel1.setViewElement(panel1Element);
        panel1.setAngularComponentName("custom-panel");
        panel1Element.setPanelEntity(panel1);
        panel1Element = viewElementRepository.save(panel1Element);


        ViewElementEntity accordionGroup1Element = new ViewElementEntity();

        accordionGroup1Element.setElementType(ElementType.ACCORDION_GROUP);

        AccordionGroupEntity accGroup1 = new AccordionGroupEntity();
        accGroup1.setViewElement(accordionGroup1Element);
        accordionGroup1Element.setAccordionGroupEntity(accGroup1);
        accordionGroup1Element = viewElementRepository.save(accordionGroup1Element);


        ViewElementEntity accordion1Element = new ViewElementEntity();

        accordion1Element.setElementType(ElementType.ACCORDION);

        AccordionEntity acc1 = new AccordionEntity();
        acc1.setViewElement(accordion1Element);
        acc1.setLabelTranslationKey("acc1.translation.key");
        acc1.setName("Accordion 1");
        acc1.setLayoutType(LayoutType.ROW);
        accordion1Element.setAccordionEntity(acc1);
        accordion1Element = viewElementRepository.save(accordion1Element);

        ViewElementEntity accordion2Element = new ViewElementEntity();

        accordion2Element.setElementType(ElementType.ACCORDION);

        AccordionEntity acc2 = new AccordionEntity();
        acc2.setViewElement(accordion2Element);
        acc2.setLabelTranslationKey("acc2.translation.key");
        acc2.setName("Accordion 2");
        acc2.setLayoutType(LayoutType.COLUMN);
        accordion2Element.setAccordionEntity(acc2);
        accordion2Element = viewElementRepository.save(accordion2Element);


        ViewElementEntity grid1Element = new ViewElementEntity();

        grid1Element.setElementType(ElementType.GRID);

        GridEntity grid1 = new GridEntity();
        grid1.setViewElement(grid1Element);
        grid1.setDataUrl("https://data.url");
        grid1.setName("Grid 1");
        grid1.setLabelTranslationKey("grid1.translation.key");
        grid1Element.setGridEntity(grid1);
        grid1Element = viewElementRepository.save(grid1Element);


        ViewElementEntity dataGrid1Element = new ViewElementEntity();

        dataGrid1Element.setElementType(ElementType.DATA_GRID);

        DataGridEntity dataGrid1 = new DataGridEntity();
        dataGrid1.setViewElement(dataGrid1Element);
        dataGrid1.setDataUrl("https://data.url");
        dataGrid1.setName("Data Grid 1");
        dataGrid1.setLabelTranslationKey("grid1.translation.key");
        dataGrid1Element.setDataGridEntity(dataGrid1);
        dataGrid1Element = viewElementRepository.save(dataGrid1Element);

        ViewElementEntity field1Element = new ViewElementEntity();

        field1Element.setElementType(ElementType.FIELD);

        FieldEntity field1 = new FieldEntity();
        field1.setViewElement(field1Element);
        field1.setWidth("160px");
        field1.setLabelTranslationKey("field1.translation.key");
        field1.setName("Field 1");
        field1.setFieldRendererType(FieldRendererType.TEXT);
        field1.setFieldType(FieldType.STRING);
        field1Element.setFieldEntity(field1);
        field1Element = viewElementRepository.save(field1Element);


        ViewElementEntity field2Element = new ViewElementEntity();

        field2Element.setElementType(ElementType.FIELD);

        FieldEntity field2 = new FieldEntity();
        field2.setViewElement(field2Element);
        field2.setWidth("160px");
        field2.setFieldType(FieldType.LONG);
        field2.setFieldRendererType(FieldRendererType.LINK);
        field2.setLabelTranslationKey("field2.translation.key");
        field2.setName("Field 2");
        field2Element.setFieldEntity(field2);
        field2Element = viewElementRepository.save(field2Element);


        // Link tab group to viewFragment as root Child
        LinkageEntity link0 = new LinkageEntity();
        link0.setViewFragment(viewFragment1);

        link0.setViewElementParent(null);
        link0.setViewElement(tab1GroupElement);

        link0 = linkageRepository.save(link0);

        // Link tab 1 to tabGroup1

        LinkageEntity link1 = new LinkageEntity();
        link1.setViewFragment(viewFragment1);

        link1.setViewElementParent(tab1GroupElement);
        link1.setViewElement(tab1Element);

        link1 = linkageRepository.save(link1);


        // Link tab 2 to tabGroup1
        LinkageEntity link2 = new LinkageEntity();
        link2.setViewFragment(viewFragment1);

        link2.setViewElementParent(tab1GroupElement);
        link2.setViewElement(tab2Element);

        link2 = linkageRepository.save(link2);


        LinkageEntity link3 = new LinkageEntity();
        link3.setViewFragment(viewFragment1);

        link3.setViewElementParent(null);
        link3.setViewElement(accordionGroup1Element);

        link3 = linkageRepository.save(link3);


        // Link acc1 to group1
        LinkageEntity link31 = new LinkageEntity();
        link31.setViewFragment(viewFragment1);

        link31.setViewElementParent(accordionGroup1Element);
        link31.setViewElement(accordion1Element);

        link31 = linkageRepository.save(link31);

        // Link acc1 to group1
        LinkageEntity link32 = new LinkageEntity();
        link32.setViewFragment(viewFragment1);

        link32.setViewElementParent(accordionGroup1Element);
        link32.setViewElement(accordion2Element);

        link32 = linkageRepository.save(link32);

        // Link panel1 to tab2
        LinkageEntity link4 = new LinkageEntity();
        link4.setViewFragment(viewFragment1);

        link4.setViewElementParent(tab2Element);
        link4.setViewElement(panel1Element);

        link4 = linkageRepository.save(link4);


        // Link grid1 to tab1
        LinkageEntity link5 = new LinkageEntity();
        link5.setViewFragment(viewFragment1);

        link5.setViewElementParent(tab1Element);
        link5.setViewElement(grid1Element);

        link5 = linkageRepository.save(link5);

        // Link field1 to grid1
        LinkageEntity link6 = new LinkageEntity();
        link6.setViewFragment(viewFragment1);

        link6.setViewElementParent(grid1Element);
        link6.setViewElement(field1Element);

        link6 = linkageRepository.save(link6);

        // Link field2 to grid1
        LinkageEntity link7 = new LinkageEntity();
        link7.setViewFragment(viewFragment1);

        link7.setViewElementParent(grid1Element);
        link7.setViewElement(field2Element);


        // Link field1 to grid1
        LinkageEntity link10 = new LinkageEntity();
        link10.setViewFragment(viewFragment1);

        link10.setViewElementParent(dataGrid1Element);
        link10.setViewElement(field1Element);

        link10 = linkageRepository.save(link10);

        // Link field2 to grid1
        LinkageEntity link11 = new LinkageEntity();
        link11.setViewFragment(viewFragment1);

        link11.setViewElementParent(dataGrid1Element);
        link11.setViewElement(field2Element);


        link11 = linkageRepository.save(link11);

        // Link field2 to grid1
        LinkageEntity link8 = new LinkageEntity();
        link8.setViewFragment(viewFragment1);

        link8.setViewElementParent(accordion1Element);
        link8.setViewElement(panel1Element);

        link8 = linkageRepository.save(link8);

        // Link field2 to grid1
        LinkageEntity link9 = new LinkageEntity();
        link9.setViewFragment(viewFragment1);

        link9.setViewElementParent(accordion2Element);
        link9.setViewElement(dataGrid1Element);

        link9 = linkageRepository.save(link9);

        OverrideElementEntity overrideElementEntity = new OverrideElementEntity();

        overrideElementEntity.setElementId(field1Element.getId());
        overrideElementEntity.setElementType(ElementType.FIELD);
        overrideElementEntity.setOverrideType(OverrideType.GLOBAL);
        overrideElementEntity.setViewFragment(viewFragment1);

        overrideElementEntity = overrideElementRepository.save(overrideElementEntity);

        OverrideElementValueEntity overrideElementValueEntity1 = new OverrideElementValueEntity();
        overrideElementValueEntity1.setOverrideElement(overrideElementEntity);
        overrideElementValueEntity1.setPropertyType(PropertyType.WIDTH);
        overrideElementValueEntity1.setValue("142px");

        overrideElementValueRepository.save(overrideElementValueEntity1);


        OverrideElementValueEntity overrideElementValueEntity3 = new OverrideElementValueEntity();
        overrideElementValueEntity3.setOverrideElement(overrideElementEntity);
        overrideElementValueEntity3.setPropertyType(PropertyType.ELEMENT_ORDER);
        overrideElementValueEntity3.setValue("3");

        overrideElementValueRepository.save(overrideElementValueEntity3);


        OverrideElementValueEntity overrideElementValueEntity5 = new OverrideElementValueEntity();
        overrideElementValueEntity5.setOverrideElement(overrideElementEntity);
        overrideElementValueEntity5.setPropertyType(PropertyType.FIELD_TYPE);
        overrideElementValueEntity5.setValue(FieldType.MONEY.name());

        overrideElementValueRepository.save(overrideElementValueEntity5);


    }
}
