package com.eshop.service.RemarkImpl;

import com.eshop.dao.RemarkDao.MyRemarkDao;
import com.eshop.entity.Remark;
import com.eshop.service.RemarkService;

import java.util.List;

public class RemarkImpl implements RemarkService {
    @Override
    public List<Remark> queryMyRemark(int userId) {

        return new MyRemarkDao().queryMyRemark(userId);
    }

    @Override
    public void updateRemark(int remarkId, String remark, String remarkLevel) {
        new MyRemarkDao().updateRemark(remarkId,remark,remarkLevel);
    }

    @Override
    public void deleteRemark(int remarkId) {
        new MyRemarkDao().deleteRemark(remarkId);
    }
}
