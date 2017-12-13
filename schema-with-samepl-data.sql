-- Adminer 4.3.1 PostgreSQL dump

DROP TABLE IF EXISTS "accordion_element";
CREATE TABLE "public"."accordion_element" (
    "accordion_id" bigint NOT NULL,
    "label_translation_key" character varying(255),
    "layout_type" character varying(255),
    "name" character varying(255),
    CONSTRAINT "accordion_element_pkey" PRIMARY KEY ("accordion_id"),
    CONSTRAINT "fk8x0tjtjfb80kfo2s56cm23h6d" FOREIGN KEY (accordion_id) REFERENCES view_element(view_element_id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "accordion_element" ("accordion_id", "label_translation_key", "layout_type", "name") VALUES
(7,	'acc1.translation.key',	'ROW',	'Accordion 1'),
(8,	'acc2.translation.key',	'COLUMN',	'Accordion 2');

DROP TABLE IF EXISTS "accordion_group_element";
CREATE TABLE "public"."accordion_group_element" (
    "accordion_group_id" bigint NOT NULL,
    CONSTRAINT "accordion_group_element_pkey" PRIMARY KEY ("accordion_group_id"),
    CONSTRAINT "fkg0c0n9y3lfe56jiohalca4e63" FOREIGN KEY (accordion_group_id) REFERENCES view_element(view_element_id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "accordion_group_element" ("accordion_group_id") VALUES
(6);

DROP TABLE IF EXISTS "data_grid_element";
CREATE TABLE "public"."data_grid_element" (
    "data_grid_id" bigint NOT NULL,
    "data_url" character varying(255),
    "label_translation_key" character varying(255),
    "name" character varying(255),
    CONSTRAINT "data_grid_element_pkey" PRIMARY KEY ("data_grid_id"),
    CONSTRAINT "fk73w0c0tjuispm824uteypesum" FOREIGN KEY (data_grid_id) REFERENCES view_element(view_element_id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "data_grid_element" ("data_grid_id", "data_url", "label_translation_key", "name") VALUES
(10,	'https://data.url',	'grid1.translation.key',	'Data Grid 1');

DROP TABLE IF EXISTS "element_links";
CREATE TABLE "public"."element_links" (
    "id" bigint NOT NULL,
    "view_element_id" bigint,
    "view_element_parent_id" bigint,
    "view_fragment_id" bigint,
    CONSTRAINT "element_links_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk1ym2cj8e5dwgh958we25csjp2" FOREIGN KEY (view_fragment_id) REFERENCES view_fragment(id) NOT DEFERRABLE,
    CONSTRAINT "fkimevb5x79ompma41a1x0lj19f" FOREIGN KEY (view_element_parent_id) REFERENCES view_element(view_element_id) NOT DEFERRABLE,
    CONSTRAINT "fkws4hbgf0akg8iwwbb0d8kcw0" FOREIGN KEY (view_element_id) REFERENCES view_element(view_element_id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "element_links" ("id", "view_element_id", "view_element_parent_id", "view_fragment_id") VALUES
(13,	2,	NULL,	1),
(14,	3,	2,	1),
(15,	4,	2,	1),
(16,	6,	NULL,	1),
(17,	7,	6,	1),
(18,	8,	6,	1),
(19,	5,	4,	1),
(20,	9,	3,	1),
(21,	11,	9,	1),
(22,	11,	10,	1),
(23,	12,	10,	1),
(24,	5,	7,	1),
(25,	10,	8,	1);

DROP TABLE IF EXISTS "field_element";
CREATE TABLE "public"."field_element" (
    "field_id" bigint NOT NULL,
    "field_type" character varying(255),
    "label_translation_key" character varying(255),
    "name" character varying(255),
    "width" character varying(255),
    CONSTRAINT "field_element_pkey" PRIMARY KEY ("field_id"),
    CONSTRAINT "fkf50pg3ycg6b9bmc079a9fdioe" FOREIGN KEY (field_id) REFERENCES view_element(view_element_id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "field_element" ("field_id", "field_type", "label_translation_key", "name", "width") VALUES
(11,	'STRING',	'field1.translation.key',	'Field 1',	'160px'),
(12,	'LONG',	'field2.translation.key',	'Field 2',	'160px');

DROP TABLE IF EXISTS "grid_element";
CREATE TABLE "public"."grid_element" (
    "grid_id" bigint NOT NULL,
    "data_url" character varying(255),
    "label_translation_key" character varying(255),
    "name" character varying(255),
    CONSTRAINT "grid_element_pkey" PRIMARY KEY ("grid_id"),
    CONSTRAINT "fke8famo8fqbhqsp4dt7d6bvmo7" FOREIGN KEY (grid_id) REFERENCES view_element(view_element_id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "grid_element" ("grid_id", "data_url", "label_translation_key", "name") VALUES
(9,	'https://data.url',	'grid1.translation.key',	'Grid 1');

DROP TABLE IF EXISTS "override_element";
CREATE TABLE "public"."override_element" (
    "id" bigint NOT NULL,
    "element_id" bigint NOT NULL,
    "element_type" character varying(255),
    "override_type" character varying(255),
    "view_fragment_id" bigint,
    CONSTRAINT "override_element_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fknb9obxigi309sdlymvs9ydo2u" FOREIGN KEY (view_fragment_id) REFERENCES view_fragment(id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "override_element" ("id", "element_id", "element_type", "override_type", "view_fragment_id") VALUES
(26,	11,	'FIELD',	'GLOBAL',	1);

DROP TABLE IF EXISTS "override_element_value";
CREATE TABLE "public"."override_element_value" (
    "id" bigint NOT NULL,
    "property_type" character varying(255),
    "value" character varying(255),
    "override_element_id" bigint,
    CONSTRAINT "override_element_value_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk4hiy4inggvtinx4g0k7bsx3jo" FOREIGN KEY (override_element_id) REFERENCES override_element(id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "override_element_value" ("id", "property_type", "value", "override_element_id") VALUES
(27,	'WIDTH',	'142px',	26),
(28,	'ELEMENT_ORDER',	'3',	26),
(29,	'FIELD_TYPE',	'MONEY',	26);

DROP TABLE IF EXISTS "panel_element";
CREATE TABLE "public"."panel_element" (
    "panel_id" bigint NOT NULL,
    "angular_component_name" character varying(255),
    CONSTRAINT "panel_element_pkey" PRIMARY KEY ("panel_id"),
    CONSTRAINT "fkiqw89n4p38chilbclmbyr0xpy" FOREIGN KEY (panel_id) REFERENCES view_element(view_element_id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "panel_element" ("panel_id", "angular_component_name") VALUES
(5,	'custom-panel');

DROP TABLE IF EXISTS "tab_element";
CREATE TABLE "public"."tab_element" (
    "tab_id" bigint NOT NULL,
    "label_translation_key" character varying(255),
    "layout_type" character varying(255),
    "name" character varying(255),
    CONSTRAINT "tab_element_pkey" PRIMARY KEY ("tab_id"),
    CONSTRAINT "fkrxmj1admi5u5i2m3x9p4won98" FOREIGN KEY (tab_id) REFERENCES view_element(view_element_id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "tab_element" ("tab_id", "label_translation_key", "layout_type", "name") VALUES
(3,	'tab1.translation.key',	'ROW',	'Tab 1'),
(4,	'tab2.translation.key',	'COLUMN',	'Tab 2');

DROP TABLE IF EXISTS "tab_group_element";
CREATE TABLE "public"."tab_group_element" (
    "tab_group_id" bigint NOT NULL,
    CONSTRAINT "tab_group_element_pkey" PRIMARY KEY ("tab_group_id"),
    CONSTRAINT "fks558dh0dj3dob3ekh07djax9f" FOREIGN KEY (tab_group_id) REFERENCES view_element(view_element_id) NOT DEFERRABLE
) WITH (oids = false);

INSERT INTO "tab_group_element" ("tab_group_id") VALUES
(2);

DROP TABLE IF EXISTS "view_element";
CREATE TABLE "public"."view_element" (
    "view_element_id" bigint NOT NULL,
    "element_type" character varying(255),
    CONSTRAINT "view_element_pkey" PRIMARY KEY ("view_element_id")
) WITH (oids = false);

INSERT INTO "view_element" ("view_element_id", "element_type") VALUES
(2,	'TAB_GROUP'),
(3,	'TAB'),
(4,	'TAB'),
(5,	'PANEL'),
(6,	'ACCORDION_GROUP'),
(7,	'ACCORDION'),
(8,	'ACCORDION'),
(9,	'GRID'),
(10,	'DATA_GRID'),
(11,	'FIELD'),
(12,	'FIELD');

DROP TABLE IF EXISTS "view_fragment";
CREATE TABLE "public"."view_fragment" (
    "id" bigint NOT NULL,
    "layout_type" character varying(255),
    "name" character varying(255),
    CONSTRAINT "view_fragment_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "view_fragment" ("id", "layout_type", "name") VALUES
(1,	'COLUMN',	'view1');

-- 2017-12-13 10:55:33.0669+00
