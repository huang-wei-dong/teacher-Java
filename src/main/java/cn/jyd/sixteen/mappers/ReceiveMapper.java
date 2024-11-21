package cn.jyd.sixteen.mappers;


import cn.jyd.sixteen.entity.Receive;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReceiveMapper <Receive> {
    Receive getReceiveById(Integer id);
    List<Receive> getReceiveAll();
    int insertReceive(Receive receive);
}
