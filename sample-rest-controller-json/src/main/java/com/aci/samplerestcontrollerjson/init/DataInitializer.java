package com.aci.samplerestcontrollerjson.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.aci.samplerestcontrollerjson.entity.FieldEntity;
import com.aci.samplerestcontrollerjson.entity.PageEntity;
import com.aci.samplerestcontrollerjson.entity.PanelEntity;
import com.aci.samplerestcontrollerjson.entity.SectionEntity;
import com.aci.samplerestcontrollerjson.repository.FieldRepository;
import com.aci.samplerestcontrollerjson.repository.PageRepository;
import com.aci.samplerestcontrollerjson.repository.PanelRepository;
import com.aci.samplerestcontrollerjson.repository.SectionRepository;
import com.aci.samplerestcontrollerjson.type.FieldType;

@Service
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private PanelRepository panelRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Override
    public void run(String... strings) throws Exception {

        PageEntity page1 = PageEntity.builder().name("page-1").build();
        PageEntity page2 = PageEntity.builder().name("page-2").build();

        page1 = pageRepository.save(page1);
        page2 = pageRepository.save(page2);

        SectionEntity page1Section1 = SectionEntity.builder().page(page1).subTitle("Section 1 Page 1 SubTitle").title("Section 1 Title").build();
        SectionEntity page1Section2 = SectionEntity.builder().page(page1).subTitle("Section 2 Page 1 SubTitle").title("Section 2 Title").build();
        SectionEntity page2Section1 = SectionEntity.builder().page(page2).subTitle("Section 1 Page 2 SubTitle").title("Section 3 Title").build();

        page1Section1 = sectionRepository.save(page1Section1);
        page1Section2 = sectionRepository.save(page1Section2);
        page2Section1 = sectionRepository.save(page2Section1);

        PanelEntity page1Section1Panel1 = PanelEntity.builder().section(page1Section1).title("Panel 1 Title").border("1px solid green").build();
        PanelEntity page1Section1Panel2 = PanelEntity.builder().section(page1Section1).title("Panel 2 Title").border("1px solid red").build();
        PanelEntity page1Section2Panel1 = PanelEntity.builder().section(page1Section2).title("Panel 3 Title").border("1px solid blue").build();

        PanelEntity page2Section1Panel1 = PanelEntity.builder().section(page2Section1).title("Panel 3 Title").border("1px solid yellow").build();

        panelRepository.save(page1Section1Panel1);
        panelRepository.save(page1Section1Panel2);
        panelRepository.save(page1Section2Panel1);
        panelRepository.save(page2Section1Panel1);

        List<PanelEntity> allPanels = panelRepository.findAll();
        for (int j = 0; j < allPanels.size(); j++) {
            PanelEntity panel = allPanels.get(j);
            for (int i = 0; i < 3; i++) {
                FieldEntity fieldEntity = FieldEntity.builder().panel(panel).label("Field: " + j + " - " + i).name("field-" + j + "-" + i).fieldType(((i + j) % 2) == 0 ? FieldType.TEXT : FieldType.NUMBER).build();
                fieldRepository.save(fieldEntity);
            }
        }

    }

}
