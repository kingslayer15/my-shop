package com.mblee.my.shop.web.admin.service;

import com.mblee.my.shop.commons.persistence.BaseService;
import com.mblee.my.shop.domain.TbContent;

public interface TbContentService extends BaseService<TbContent> {
    /**
     * 根据类目 ID 删除内容
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}
