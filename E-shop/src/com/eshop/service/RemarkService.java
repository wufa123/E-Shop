package com.eshop.service;

import com.eshop.entity.Remark;

import java.util.List;

/**
 * 评论接口
 */
public interface RemarkService {

    public List<Remark> queryMyRemark(int userId);

    public void updateRemark(int remarkId,String remark,String remarkLevel);

    public void deleteRemark(int remarkId);

}
