package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Active;
import generator.service.ActiveService;
import generator.mapper.ActiveMapper;
import org.springframework.stereotype.Service;

/**
* @author 1
* @description 针对表【active】的数据库操作Service实现
* @createDate 2024-11-08 00:24:19
*/
@Service
public class ActiveServiceImpl extends ServiceImpl<ActiveMapper, Active>
    implements ActiveService{

}




