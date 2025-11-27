package com.example.umc9th.domain.mission.service.query;


import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MissionResDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public MissionResDto.MissionPreViewListDto findStoreMission(Long storeId, Integer page) {
        // - 가게를 가져온다 (가게 존재 여부 검증)
        Store store = storeRepository.findByStoreId(storeId)
                //    - 없으면 예외 터뜨린다
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));
        //- 가게에 맞는 리뷰를 가져온다 (Offset 페이징)
        PageRequest pageRequest = PageRequest.of(page-1, 10);
        Page<Mission> result = missionRepository.findAllByStore(store, pageRequest);

        return MissionConverter.toMissionPreViewListDto(result);
    }
}
