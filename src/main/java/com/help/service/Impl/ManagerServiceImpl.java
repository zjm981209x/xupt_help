package com.help.service.Impl;

import com.help.dao.ManagerDao;
import com.help.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public int deleteById(int taskId) {
        return managerDao.deleteById(taskId);
    }

    @Override
    public int passTrade(int taskId) {
        return managerDao.passTrade(taskId);
    }

    @Override
    public int update(int taskId) {
        return managerDao.update(taskId);
    }
}
