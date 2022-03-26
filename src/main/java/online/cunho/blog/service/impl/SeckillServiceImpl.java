package online.cunho.blog.service.impl;

import online.cunho.blog.dao.TbSeckillMapper;
import online.cunho.blog.entity.TbSeckill;
import online.cunho.blog.service.SeckillService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private TbSeckillMapper tbSeckillMapper;

    public TbSeckill selectByPrimaryKey(Long seckillId) {
        return tbSeckillMapper.selectByPrimaryKey(seckillId);
    }
}
