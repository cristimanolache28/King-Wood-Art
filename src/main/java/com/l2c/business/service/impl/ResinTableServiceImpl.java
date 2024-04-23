package com.l2c.business.service.impl;

import com.l2c.business.dto.ResinTableDto;
import com.l2c.business.entity.ResinTable;
import com.l2c.business.exception.ResourceNotFoundException;
import com.l2c.business.repository.ResinTableRepository;
import com.l2c.business.service.ResinTableService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResinTableServiceImpl implements ResinTableService {

    @Autowired
    private ResinTableRepository tableRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResinTableDto createResinTable(ResinTableDto resinTableDto) {
        ResinTable resinTable = mapToEntity(resinTableDto);

        ResinTable newResinTable = tableRepository.save(resinTable);

        ResinTableDto resinTableResponse = mapToDto(newResinTable);
        return resinTableResponse;

    }

    @Override
    public ResinTableDto getResinTableById(Integer id) {
        ResinTable resinTable = tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table", "id", id));

        ResinTableDto resinTableDto = mapToDto(resinTable);
        return  resinTableDto;
    }

    @Override
    public void deleteResinTableById(Integer id) {
        ResinTable resinTable = tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table", "id", id));

        tableRepository.delete(resinTable);
    }

    @Override
    public ResinTableDto updateTable(ResinTableDto tableDto, Integer id) {
        ResinTable table = tableRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Table", "id", id));

        table.setName(tableDto.getName());
        table.setDescription(tableDto.getDescription());
        table.setPrice(tableDto.getPrice());
        table.setLength(tableDto.getLength());
        table.setWidth(tableDto.getWidth());
        table.setThickness(tableDto.getThickness());
        table.setWidth(tableDto.getWeight());
        table.setQuantity(tableDto.getQuantity());
        table.setTableSize(tableDto.getTableSize());
        table.setTableStatus(tableDto.getTableStatus());

        ResinTable updatedTable = tableRepository.save(table);

        return mapToDto(updatedTable);
    }

    // convert dto to entity
    private ResinTable mapToEntity(ResinTableDto resinTableDto) {
        ResinTable resinTable = modelMapper.map(resinTableDto, ResinTable.class);
        return resinTable;
    }

    // convert entity to dto
    private ResinTableDto mapToDto(ResinTable resinTable) {
        ResinTableDto resinTableDto = modelMapper.map(resinTable, ResinTableDto.class);
        return resinTableDto;
    }
}
