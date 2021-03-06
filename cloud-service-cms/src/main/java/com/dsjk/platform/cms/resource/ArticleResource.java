package com.dsjk.platform.cms.resource;

import com.dsjk.platform.cms.service.ArticleService;
import com.dsjk.platform.common.bean.cms.CmsArticle;
import com.dsjk.platform.common.service.user.IArticleClient;
import com.dsjk.platform.common.utils.BeanMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author fengcheng
 * @version 2017/3/25
 */
@RestController
public class ArticleResource implements IArticleClient {

    private final ArticleService articleService;

    @Autowired
    public ArticleResource(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    @RequestMapping(value = "/cms/article/{id}", method = RequestMethod.GET)
    public CmsArticle get(@RequestParam(value = "id") String id) {
        return articleService.get(id);
    }

    @Override
    @RequestMapping(value = "/cms/article/page", method = RequestMethod.GET)
    public PageInfo<CmsArticle> getPage(@RequestParam Map map) {
        CmsArticle article = BeanMapper.map(map, CmsArticle.class);
        return articleService.getPage(article);
    }
}
