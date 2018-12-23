package com.ugrow.internet.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ugrow.internet.Entity.BackMaterial;
import com.ugrow.internet.Mapper.BackMaterialMapper;
import com.ugrow.internet.Service.BackMaterialService;
import com.ugrow.internet.Utils.BackMaterialSearchInfo;

@Service
public class BackMaterialServiceImp implements BackMaterialService {
	@Autowired
	BackMaterialMapper mapper;

	@Override
	public List<BackMaterial> index(BackMaterialSearchInfo info) {
		return mapper.index(info);
	}

	@Override
	@Transactional
	public int insert(BackMaterial b) {
		String[] arrtitle;
		String[] arrurl;
		arrtitle=b.getTitle().split(",");
		arrurl=b.getUrl().split(",");
		for(int k=0;k<arrtitle.length;k++) {
			String[] arrurl1;
			arrurl1=arrurl[k].split("///");
			b.setTitle(arrtitle[k]);
			String[] arr;
			arr=arrurl1[1].split(":");
			b.setUrl(arr[1]);
			mapper.insert(b);
		}
		return 1;
	}

	@Override
	public int update(BackMaterial b) {
		return mapper.update(b);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public BackMaterial getByid(int id) {
		return mapper.getByid(id);
	}

	@Override
	public int count(BackMaterialSearchInfo info) {
		return mapper.count(info);
	}

}
