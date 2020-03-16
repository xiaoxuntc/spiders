package com.sean.service;

import com.sean.entity.Page;

/**
 * @program: spiders
 * @description: page download interface
 * @author: Sean
 * @create: 2020-03-15 16:48
 **/
public interface InterfaceDownLoadService {

    Page download(String url);
}
