package com.sean.service.impl;

import com.sean.entity.Page;
import com.sean.service.InterfaceDownLoadService;
import com.sean.util.PageDownloadUtil;

/**
 * @program: spiders
 * @description: page download class
 * @author: Sean
 * @create: 2020-03-15 16:50
 **/
public class HttpClientDownloadService implements InterfaceDownLoadService {

    @Override
    public Page download(String url) {
        Page page = new Page();
        page.setContent(PageDownloadUtil.getPageContent(url));
        return page;
    }
}
