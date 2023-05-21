package com.brandmaker.skyhigh.ac.mpcparser.dao.enums.impl;

import com.brandmaker.skyhigh.ac.mpcparser.dao.enums.PersistentEnum;

public enum DimensionTypes implements PersistentEnum {
    TEXT_DIMENSION_TYPE(2, DimensionBaseType.FREETEXT),
    M_SELECTABLE_DIMENSION_TYPE(3, DimensionBaseType.LIST),
    SELECTABLE_DIMENSION_TYPE(4, DimensionBaseType.LIST),
    MW_SELECTABLE_DIMENSION_TYPE(5, DimensionBaseType.LIST),
    STRUCTURED_TEXT_DIMENSION_TYPE(6, DimensionBaseType.STRUCTURED),
    CONTINUES_TEXT_DIMENSION_TYPE(7, DimensionBaseType.FREETEXT);

    private int id;
    private DimensionBaseType baseType;

    DimensionTypes(int id, DimensionBaseType baseType)
    {
        this.id = id;
        this.baseType = baseType;
    }

    @Override
    public int getId()
    {
        return id;
    }

    public DimensionBaseType getBaseType()
    {
        return baseType;
    }
    public String getName()
    {
        return name();
    }

    public static DimensionTypes getInstance(int searchId)
    {
        DimensionTypes[] types = DimensionTypes.values();
        for (int i = 0; i < types.length; i++)
        {
            if (types[i].id == searchId)
            {
                return types[i];
            }
        }
        return null;
    }
}
