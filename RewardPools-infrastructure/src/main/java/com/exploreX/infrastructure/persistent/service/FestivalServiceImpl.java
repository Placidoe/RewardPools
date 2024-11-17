package com.exploreX.infrastructure.persistent.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.exploreX.infrastructure.persistent.po.Festival;
import com.exploreX.infrastructure.persistent.dao.FestivalDAO;
import org.springframework.stereotype.Service;

/**
* @author 1
* @description 针对表【festival】的数据库操作Service实现
* @createDate 2024-11-13 09:44:13
*/
@Service
public class FestivalServiceImpl extends ServiceImpl<FestivalDAO, Festival>
    implements FestivalService {

}




