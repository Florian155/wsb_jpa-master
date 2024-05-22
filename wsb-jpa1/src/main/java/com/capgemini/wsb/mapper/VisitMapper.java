package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.ArrayList;
import java.util.List;

public final class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setVisitDateTime(visitEntity.getTime());
        visitTO.setDoctorName(visitEntity.getDoctor().getLastName()); // Zakładając, że masz dostęp do danych lekarza

        return visitTO;
    }

    public static List<VisitTO> mapToTOList(final List<VisitEntity> visitEntities) {
        if (visitEntities == null) {
            return null;
        }
        List<VisitTO> visitTOs = new ArrayList<>();
        for (VisitEntity visitEntity : visitEntities) {
            visitTOs.add(mapToTO(visitEntity));
        }
        return visitTOs;
    }
}