package com.quicksilvarad.jmeterTest.mapper;

import com.quicksilvarad.jmeterTest.dto.OrderDTO;
import tools.jackson.databind.json.JsonMapper;

public class OrderMapper {

    public OrderDTO convertToDTO(String order)
    {
        JsonMapper jsonMapper= new JsonMapper();
        return jsonMapper.readValue(order, OrderDTO.class);
    }
}
