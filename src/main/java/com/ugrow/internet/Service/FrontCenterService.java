package com.ugrow.internet.Service;

import java.util.List;

import com.ugrow.internet.Utils.FrontCenterSearchinfo;
import com.ugrow.internet.Utils.FrontNewsSearchinfo;
import com.ugrow.internet.Entity.BackCenter;
import com.ugrow.internet.Entity.BackEducation;
import com.ugrow.internet.Entity.BackNews;

public interface FrontCenterService {
	public BackCenter index(FrontCenterSearchinfo info);
}
