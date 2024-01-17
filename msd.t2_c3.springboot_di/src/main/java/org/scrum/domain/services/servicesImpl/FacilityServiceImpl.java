package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.Item;
import org.scrum.domain.project.dto.FacilityDto;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.project.utils.ImageUpload;
import org.scrum.domain.repositories.FacilityRepository;
import org.scrum.domain.services.FacilityService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {
    private final FacilityRepository facilityRepository;
    private final ImageUpload imageUpload;

    @Override
    public List<FacilityDto> getAll() {
        return transferData(facilityRepository.findAll());
    }

    private List<FacilityDto> transferData(List<Facility> facilities) {
        List<FacilityDto> facilityDtos = new ArrayList<>();
        for (Facility facility : facilities) {
            FacilityDto facilityDto = new FacilityDto(facility);
            facilityDtos.add(facilityDto);
        }
        return facilityDtos;
    }

    @Override
    public Facility addFacility(MultipartFile imageItem, FacilityDto facilityDto) {
        Facility newFacility = new Facility(facilityDto.getFacilityName(), facilityDto.getDescription(), facilityDto.getCostPrice(), facilityDto.getDuration(), facilityDto.getCategory(), facilityDto.getPhoto(), facilityDto.isCurrentDisponibility());
        try {
            if (imageItem == null) {
                newFacility.setPhoto(null);
            } else {
                imageUpload.uploadImage(imageItem);
                newFacility.setPhoto(Base64.getEncoder().encodeToString(imageItem.getBytes()));
            }
            return facilityRepository.save(newFacility);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
