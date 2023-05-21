package com.brandmaker.skyhigh.ac.mpcparser.dao.enums.impl;

import com.brandmaker.skyhigh.ac.mpcparser.dao.enums.PersistentEnum;

public enum DimensionBaseType implements PersistentEnum
{
    LIST(4)
            {
                @Override
                public DimensionTypes[] getSubDimensionTypes()
                {
                    return new DimensionTypes[]{DimensionTypes.SELECTABLE_DIMENSION_TYPE,DimensionTypes.M_SELECTABLE_DIMENSION_TYPE,DimensionTypes.MW_SELECTABLE_DIMENSION_TYPE};
                }
            },
    STRUCTURED(1)
            {
                @Override
                public DimensionTypes[] getSubDimensionTypes()
                {
                    return new DimensionTypes[]{DimensionTypes.STRUCTURED_TEXT_DIMENSION_TYPE};
                }
            },
    FREETEXT(3)
            {
                @Override
                public DimensionTypes[] getSubDimensionTypes()
                {
                    return new DimensionTypes[]{DimensionTypes.TEXT_DIMENSION_TYPE,DimensionTypes.CONTINUES_TEXT_DIMENSION_TYPE};
                }
            };

    private int id;

    private DimensionBaseType(int id)
    {
        this.id = id;
    }

    public abstract DimensionTypes[] getSubDimensionTypes();

    @Override
    public int getId()
    {
        return id;
    }

    public static DimensionBaseType getById(int id)
    {
        for (DimensionBaseType state : DimensionBaseType.values())
        {
            if (state.getId() == id)
            {
                return state;
            }
        }
        return null;
    }

}
