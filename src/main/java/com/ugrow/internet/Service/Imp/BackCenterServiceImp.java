package com.ugrow.internet.Service.Imp;

import com.ugrow.internet.Entity.BackCenter;
import com.ugrow.internet.Mapper.BackCenterMapper;
import com.ugrow.internet.Service.BackCenterService;
import com.ugrow.internet.Utils.SearchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BackCenterServiceImp implements BackCenterService {
    @Autowired
    BackCenterMapper center_mapper;
    @Override
    public void updateCenter(BackCenter center) {
        center_mapper.updateCenter(center);
    }

    @Override
    public List<BackCenter> selectCenter(SearchInfo SearchInfo) {
        return center_mapper.selectCenter(SearchInfo);
    }

    @Override
    public void insertCenter(BackCenter center) {
        center_mapper.insertCenter(center);
    }
}
