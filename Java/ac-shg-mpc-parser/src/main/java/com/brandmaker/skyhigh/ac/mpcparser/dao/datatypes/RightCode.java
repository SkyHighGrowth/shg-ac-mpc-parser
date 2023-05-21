package com.brandmaker.skyhigh.ac.mpcparser.dao.datatypes;

import java.io.Serializable;
import java.lang.reflect.Field;

public class RightCode implements Serializable
{
    private static final long serialVersionUID = 3675904960607112256L;


    public static final RightCode MODULE_ACCESS = new RightCode(1);

    /**
     * @code 2
     * @label GENERAL_WRITE
     * @since 1.0
     */
    public static final RightCode GENERAL_WRITE = new RightCode(2);

    /**
     * @code 3
     * @label MARKER_READ
     */
    public static final RightCode MARKER_READ = new RightCode(3);

    /**
     * @code 4
     * @label MARKER_WRITE
     */
    public static final RightCode MARKER_WRITE = new RightCode(4);

    /**
     * @code 5
     * @label ATTACHMENT_READ
     */
    public static final RightCode ATTACHMENT_READ = new RightCode(5);

    /**
     * @code 6
     * @label ATTACHMENT_WRITE
     */
    public static final RightCode ATTACHMENT_WRITE = new RightCode(6);

    /**
     * @code 7
     * @label DIMENSIONS_READ
     */
    public static final RightCode DIMENSIONS_READ = new RightCode(7);

    /**
     * @code 8
     * @label DIMENSIONS_WRITE
     */
    public static final RightCode DIMENSIONS_WRITE = new RightCode(8);

    /**
     * @code 9
     * @label KPIS_READ
     */
    public static final RightCode KPIS_READ = new RightCode(9);

    /**
     * @code 10
     * @label KPIS_WRITE
     */
    public static final RightCode KPIS_WRITE = new RightCode(10);

    /**
     * @code 11
     * @label PERIOD_READ
     */
    public static final RightCode PERIOD_READ = new RightCode(11);

    /**
     * @code 12
     * @label PERIOD_WRITE
     */
    public static final RightCode PERIOD_WRITE = new RightCode(12);

    /**
     * @code 13
     * @label TASK_READ
     */
    public static final RightCode TASK_READ = new RightCode(13);

    /**
     * @code 14
     * @label TASK_WRITE
     */
    public static final RightCode TASK_WRITE = new RightCode(14);

    /**
     * display : see budget
     * @code 15
     * @label BUDGET_READ
     */
    public static final RightCode BUDGET_READ = new RightCode(15);

    /**
     * display : add or change budgets
     * @code 16
     * @label BUDGET_WRITE
     */
    public static final RightCode BUDGET_WRITE = new RightCode(16);

    /**
     * display : see bills
     * @code 17
     * @label BILL_READ
     */
    public static final RightCode BILL_READ = new RightCode(17);

    /**
     * @code 18
     * @label BILL_WRITE
     */
    public static final RightCode BILL_WRITE = new RightCode(18);

    /**
     * @code 19
     * @label ELEMENT_WRITE
     */
    public static final RightCode ELEMENT_WRITE = new RightCode(19);

    /**
     * @code 20
     * @label MANAGE_GROUPS_WRITE
     */
    public static final RightCode MANAGE_GROUPS_WRITE = new RightCode(20);

    /**
     *
     */
//	public static final RightCode CATEGORIES_READ = new RightCode(21);

    /**
     * display : manage categories
     * @code 22
     * @label MANAGE_CATEGORIES
     */
    public static final RightCode MANAGE_CATEGORIES = new RightCode(22);

    /**
     * display : see calendar
     * @code 23
     * @label CALENDAR_STRUCTURE_READ
     */
    //public static final RightCode CALENDAR_STRUCTURE_READ = new RightCode(23);

    /**
     * display : writing acces to the tree structure
     * @code 24
     * @label MANAGE_CALENDAR_STRUCTURE
     */
    public static final RightCode MANAGE_CALENDAR_STRUCTURE = new RightCode(24);

    /**
     * display : see settings for years
     * @code 25
     * @label YEAR_READ
     */
    //public static final RightCode YEAR_READ = new RightCode(25);

    /**
     * @code 26
     * @label MANAGE_YEAR
     */
    public static final RightCode MANAGE_YEAR = new RightCode(26);

    /**
     * @code 27
     * @label MANAGE_KPIS_READ
     */
    //public static final RightCode MANAGE_KPIS_READ = new RightCode(27);

    /**
     * @code 28
     * @label MANAGE_KPIS
     */
    public static final RightCode MANAGE_KPIS = new RightCode(28);

    /**
     * @code 29
     * @label MANAGE_DIMENSIONS_READ
     */
    //public static final RightCode MANAGE_DIMENSIONS_READ = new RightCode(29);

    /**
     * @code 30
     * @label MANAGE_DIMENSIONS
     */
    public static final RightCode MANAGE_DIMENSIONS = new RightCode(30);

    /**
     * display : able to invite users to the planning
     * @code 31
     * @label USERS_INVITE
     */
    public static final RightCode MANAGE_GROUPS_TO_NODE = new RightCode(33); // old USERS_EDIT_GROUP

    public static final RightCode MODULE_CALENDAR_VISIBLE = new RightCode(37);

    @Deprecated
    /**
     * @deprecated
     * @since 6.1
     */
    public static final RightCode MODULE_BUDGET_VISIBLE = new RightCode(38);

    public static final RightCode MODULE_REPORTS_VISIBLE = new RightCode(39);

    @Deprecated
    /**
     * @deprecated
     * @since 6.0.1
     */
    public static final RightCode MODULE_SETTINGS_VISIBLE = new RightCode(40);

    public static final RightCode EXPORTS_VISIBLE = new RightCode(41);

    public static final RightCode SAVE_VIEWS_VISIBLE = new RightCode(42);

    public static final RightCode PUBLISH_VIEWS_VISIBLE = new RightCode(43);

    /**
     * @code 49
     * @label MANDATOR_SETTINGS_GENERAL_READ
     */
    //public static final RightCode MANDATOR_SETTINGS_GENERAL_READ = new RightCode(49);

    /**
     * @code 50
     * @label MANDATOR_SETTINGS_GENERAL
     */
    public static final RightCode MANDATOR_SETTINGS_GENERAL = new RightCode(50);

    /**
     * @code 51
     * @label MODULE_TOOLS_VISIBLE
     */
    public static final RightCode MODULE_TOOLS_VISIBLE = new RightCode(51);

    /**
     * @code 52
     * @label SORTANDFILTER_READ
     */
//	public static final RightCode SORTANDFILTER_READ = new RightCode(52);

    /**
     * @code 53
     * @label SORTANDFILTER_WRITE
     */
//	public static final RightCode SORTANDFILTER_WRITE = new RightCode(53);

    /**
     * @code 54
     * @label SUNKCOST_READ
     */
    public static final RightCode SUNKCOST_READ = new RightCode(54);

    /**
     * @code 55
     * @label SUNKCOST_WRITE
     */
    public static final RightCode SUNKCOST_WRITE = new RightCode(55);

    /**
     * annex general info read access
     * @code 57
     * @label GENERAL_READ
     * @since 1.0
     */
    public static final RightCode GENERAL_READ = new RightCode(57);

    /**
     * @code 1001010
     * @label PLUGIN_DEUBA_SAPIMPORT_USE
     */
    //public static final RightCode PLUGIN_DEUBA_SAPIMPORT_USE = new RightCode(1001010);

    /**
     * @code 1001020
     * @label PLUGIN_DEUBA_EXPORT_USE
     */
    @Deprecated
    /**
     * @deprecated
     * @since 6.7
     */
    public static final RightCode PLUGIN_DEUBA_EXPORT_USE = new RightCode(1001020);

    @Deprecated
    /**
     * @deprecated
     * @since 6.7
     */
    public static final RightCode PLUGIN_DEUBA_IMPORT_KVA_INVOICES_USE = new RightCode(1001030);
    /**
     public static final RightCode PLUGIN_HOME_MAINTENANCE_USE = new RightCode(1002010);
     public static final RightCode PLUGIN_FRIENDSHIPS_USE = new RightCode(1002020);
     public static final RightCode PLUGIN_ATTENDANCES_USE = new RightCode(1002030);
     */

//	public static final RightCode GROUPS_READ = new RightCode(58);

    /**
     * @code 59
     * @label MAPS_MANAGE_GROUPS_TO_DIMENSIONS
     * @since 5.12
     */
    public static final RightCode MANAGE_GROUPS_TO_DIMENSIONS = new RightCode(59); // old MANAGE_DIMENSIONS

    /**
     * @code 60
     * @label JOB_WRITE
     * @since 5.22
     */
    public static final RightCode JOB_WRITE = new RightCode(60);


    /**
     * @code 61
     * @label MAPS_MANAGE_APPROVERS
     * @since 5.6PR2
     */
    public static final RightCode MAPS_MANAGE_APPROVERS = new RightCode(61);

    /**
     * @code 62
     * @label MDF_READ
     * @since 5.6PR2
     */
    public static final RightCode MDF_READ = new RightCode(62);

    /**
     * @code 63
     * @label MF_WRITE
     * @since 5.6PR2
     */
    public static final RightCode MDF_WRITE = new RightCode(63);

    /**
     * excel import access
     * @code 64
     * @label EXCEL_IMPORT
     * @since 1.0
     */
    public static final RightCode EXCEL_IMPORT = new RightCode(64);

    public static final RightCode MODULE_DASHBOARD_VISIBLE = new RightCode(65);

    //public static final RightCode MAPS_EXCHANGE_RATES_READ = new RightCode(66);
    public static final RightCode MAPS_MANAGE_EXCHANGE_RATES  = new RightCode(67);
    //    public static final RightCode CONTENT_WRITE  = new RightCode(68);
    public static final RightCode MANAGE_GROUPS_TO_USERS  = new RightCode(69);

    public static final RightCode ELEMENT_DELETE = new RightCode(70);
    public static final RightCode ELEMENT_COPY = new RightCode(71);
    public static final RightCode ELEMENT_RELOCATE = new RightCode(72);

    public static final RightCode ELEMENT_ACTIVITY_STREAM = new RightCode(73);
    public static final RightCode CHANGE_LOG = new RightCode(74);


    //public static final RightCode MANAGE_ELEMENT_TYPE_READ = new RightCode(75);
    public static final RightCode MANAGE_ELEMENT_TYPE = new RightCode(76);


    public static final RightCode MAPS_MANAGE_RULES = new RightCode(77);//right from accenture for rule engine
    public static final RightCode MAPS_ELEMENT_EXTERNAL_RESOURCES = new RightCode(78);
    public static final RightCode MANAGE_MARKER = new RightCode(79);
    //    public static final RightCode MANAGE_MARKER_READ = new RightCode(80);
    public static final RightCode ELEMENT_MANAGE_WATCHER = new RightCode(81);

    //public static final RightCode MANAGE_FEES_READ = new RightCode(82);
    public static final RightCode MANAGE_FEES = new RightCode(83);

    public static final RightCode FEES_READ = new RightCode(84);
    public static final RightCode FEES_WRITE = new RightCode(85);

    public static final RightCode FEES_OVERWRITE_GLOBAL = new RightCode(86);

    public static final RightCode TARGET_READ = new RightCode(87);
    public static final RightCode TARGET_WRITE = new RightCode(88);

    public static final RightCode MANAGE_BUDGET_DEFAULT_VIEW = new RightCode(89);
    public static final RightCode MANAGE_LOCK_BUDGETS =  new RightCode(90);




    private static RightCode enumerations[] =
            {
                    MODULE_ACCESS,
                    GENERAL_READ,
                    GENERAL_WRITE,

                    MARKER_READ,
                    MARKER_WRITE,

                    ATTACHMENT_READ,
                    ATTACHMENT_WRITE,

                    DIMENSIONS_READ,
                    DIMENSIONS_WRITE,

                    KPIS_READ,
                    KPIS_WRITE,

                    //Calendar
                    PERIOD_READ,
                    PERIOD_WRITE,

                    TASK_READ,
                    TASK_WRITE,

                    //Budget
                    BUDGET_READ,
                    BUDGET_WRITE,

                    BILL_READ,
                    BILL_WRITE,

                    MDF_READ,
                    MDF_WRITE,

                    //Structure
                    ELEMENT_WRITE,
                    MANAGE_GROUPS_WRITE,

                    //Global things
                    //Admin settings
//		CATEGORIES_READ,
                    MANAGE_CATEGORIES,

//		CALENDAR_STRUCTURE_READ,
                    MANAGE_CALENDAR_STRUCTURE,

                    //YEAR_READ,
                    MANAGE_YEAR,

                    //MANAGE_KPIS_READ,
                    MANAGE_KPIS,

                    //MANAGE_DIMENSIONS_READ,
                    MANAGE_DIMENSIONS,

                    MANAGE_GROUPS_TO_NODE,

                    MAPS_MANAGE_APPROVERS,

                    //Global functions
                    MODULE_CALENDAR_VISIBLE,
                    MODULE_BUDGET_VISIBLE,
                    MODULE_REPORTS_VISIBLE,
                    MODULE_SETTINGS_VISIBLE,

                    EXPORTS_VISIBLE,
                    SAVE_VIEWS_VISIBLE,
                    PUBLISH_VIEWS_VISIBLE,

                    //MANDATOR_SETTINGS_GENERAL_READ,
                    MANDATOR_SETTINGS_GENERAL,

                    MODULE_TOOLS_VISIBLE,

                    SUNKCOST_READ,
                    SUNKCOST_WRITE,

                    PLUGIN_DEUBA_EXPORT_USE,
                    PLUGIN_DEUBA_IMPORT_KVA_INVOICES_USE,

                    MANAGE_GROUPS_TO_DIMENSIONS,

                    //Create managed tasks
                    JOB_WRITE,
                    EXCEL_IMPORT,
                    MODULE_DASHBOARD_VISIBLE,
                    //MAPS_EXCHANGE_RATES_READ,
                    MAPS_MANAGE_EXCHANGE_RATES,
//        CONTENT_WRITE,
                    MANAGE_GROUPS_TO_USERS,
                    ELEMENT_DELETE,
                    ELEMENT_COPY,
                    ELEMENT_RELOCATE,
                    ELEMENT_ACTIVITY_STREAM,
                    CHANGE_LOG,
                    //MANAGE_ELEMENT_TYPE_READ,
                    MANAGE_ELEMENT_TYPE,
                    MAPS_MANAGE_RULES,
//        MANAGE_MARKER_READ,
                    MANAGE_MARKER,
                    MAPS_MANAGE_RULES,
                    MAPS_ELEMENT_EXTERNAL_RESOURCES,
                    ELEMENT_MANAGE_WATCHER,
                    //MANAGE_FEES_READ,
                    MANAGE_FEES,
                    FEES_READ,
                    FEES_WRITE,
                    FEES_OVERWRITE_GLOBAL,
                    TARGET_READ,
                    TARGET_WRITE,
                    MANAGE_BUDGET_DEFAULT_VIEW,
                    MANAGE_LOCK_BUDGETS
            };

    private int id;

    private RightCode(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public static RightCode getInstance(int searchId)
    {
        for (int i = 0; i < enumerations.length; i++)
        {
            if (enumerations[i].id == searchId)
            {
                return enumerations[i];
            }
        }
        return null;
    }

    public String getName()
    {
        Field[] fields = this.getClass().getFields();
        for (Field f : fields)
        {
            try
            {
                if (((RightCode)f.get(this)).id == this.id)
                    return f.getName();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof RightCode)
        {
            RightCode enumObj = (RightCode) obj;

            if (enumObj.id == this.id)
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return this.id;
    }
}
