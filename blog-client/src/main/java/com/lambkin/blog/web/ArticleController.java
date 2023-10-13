package com.lambkin.blog.web;

import com.lambkin.blog.model.SearchForEsRequest;
import com.lambkin.blog.model.dto.ArticlePageDto;
import com.lambkin.blog.model.vo.ArticleDetailVo;
import com.lambkin.blog.service.IArticleService;
import com.lambkin.blog.ya.ApiResponse;
import com.lambkin.blog.ya.PageRequest;
import com.lambkin.blog.ya.YaPage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * <p>文章表--web</p>
 *
 * @author lambkinya
 * @since 2023-09-17 14:13:13
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Resource
    private IArticleService articleServiceImpl;


    @PostMapping("/search-es")
    public YaPage<?> searchForEsRpc(@RequestBody SearchForEsRequest requestData) {
        String searchText = requestData.getSearchText();
        long pageNum = requestData.getPageNum();
        long pageSize = requestData.getPageSize();
        return articleServiceImpl.doSearch(searchText, pageNum, pageSize);
    }

    @PostMapping("/list-es")
    public ApiResponse<?> searchForEs(@RequestBody SearchForEsRequest requestData) {
        String searchText = requestData.getSearchText();
        long pageNum = requestData.getPageNum();
        long pageSize = requestData.getPageSize();
        YaPage<?> result = articleServiceImpl.doSearch(searchText, pageNum, pageSize);
        return ApiResponse.ok(result);
    }

    @PostMapping("/list")
    public ApiResponse<?> queryArticleByConditionPage(@RequestBody ArticlePageDto dto) {
        YaPage<?> result = articleServiceImpl.queryArticleByConditionPage(dto);
        return ApiResponse.ok(result);
    }


    @PostMapping("/list-admin")
    public ApiResponse<?> queryArticlePage(@RequestBody ArticlePageDto dto) {
        YaPage<?> result = articleServiceImpl.queryArticleByConditionPageAdmin(dto);
        return ApiResponse.ok(result);
    }


    @GetMapping("/detail")
    public ApiResponse<?> queryArticleDetailByNo(String no) {
        ArticleDetailVo result = articleServiceImpl.queryArticleDetailByNo(no);
        return ApiResponse.ok(result);
    }


    @PostMapping("/recommend")
    public ApiResponse<?> queryRecommendArticlePage(@RequestBody PageRequest dto) {
        YaPage<?> result = articleServiceImpl.queryRecommendArticlePage(dto.getCurrent(), dto.getSize());
        return ApiResponse.ok(result);
    }

}

