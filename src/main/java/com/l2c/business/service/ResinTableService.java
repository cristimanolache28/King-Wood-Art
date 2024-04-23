package com.l2c.business.service;

import com.l2c.business.dto.ResinTableDto;

public interface ResinTableService {
    ResinTableDto createResinTable(ResinTableDto resinTableDto);

    ResinTableDto getResinTableById(Integer id);

    void deleteResinTableById(Integer id);

    ResinTableDto updateTable(ResinTableDto resinTableDto, Integer id);
}
