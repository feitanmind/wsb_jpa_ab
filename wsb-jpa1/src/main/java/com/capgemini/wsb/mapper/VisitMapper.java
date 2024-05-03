package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public final class VisitMapper {
    public static VisitTO MapToVisitTO(final VisitEntity visitEntity)
    {
        if(visitEntity == null) return null;
        return new VisitTO(visitEntity.getId(),visitEntity.getDescription(), visitEntity.getTime());
    }
    public static VisitEntity MapToVisitEntity(final VisitTO visitTO)
    {
        if(visitTO  == null) return null;
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        return visitEntity;

    }

}
