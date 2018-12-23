package com.ugrow.internet.Service;

import com.ugrow.internet.Entity.BackCenter;
import com.ugrow.internet.Utils.SearchInfo;

import java.util.List;

public interface BackCenterService {
    public void updateCenter(BackCenter center);
    public List<BackCenter> selectCenter(SearchInfo SearchInfo);
    public void insertCenter(BackCenter center);
}
