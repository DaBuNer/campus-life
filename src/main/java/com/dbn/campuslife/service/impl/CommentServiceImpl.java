package com.dbn.campuslife.service.impl;

import com.dbn.campuslife.entity.comment.*;
import com.dbn.campuslife.entity.user.UserInfoPO;
import com.dbn.campuslife.mapper.CommentMapper;
import com.dbn.campuslife.service.ICommentService;
import com.dbn.campuslife.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.stream.events.Comment;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 评论服务层实现类
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    CommentMapper commentMapper;

    @Override
    public void addComment(AddCommentDTO addCommentDTO, UserInfoPO userInfo) {

        addCommentDTO.setUserId(userInfo.getId());

        addCommentDTO.checkProperty();

        commentMapper.addComment(addCommentDTO);
    }

    @Override
    public Result<CommentPO> listComments(ListCommentDTO listCommentDTO, UserInfoPO userInfo) {

        Map<Integer, CommentPO> map = new Hashtable<>();
        /*添加登录人ID*/
        listCommentDTO.setUserId(userInfo.getId());
        /*检查必填字段是否为空*/
        listCommentDTO.checkProperty();
        commentMapper.listComments(listCommentDTO).parallelStream().forEach(s -> {
            CommentPO comment = map.get(s.getId());
            if (comment != null) {
                s.addAllChildren(comment.getChildren());
            }
            map.put(s.getId(), s);
            comment = map.get(s.getParentId());
            if (comment != null) {
                comment.addChildren(s);
            } else {
                map.put(s.getParentId(), new CommentPO().addChildren(s));
            }
        });
        List<CommentPO> list = map.entrySet().parallelStream().filter(s -> s.getKey() == 0).map(Map.Entry::getValue).collect(Collectors.toList());
        if (list.size() == 0) {
            return new Result<>();
        }
        List<CommentPO> comments = list.get(0).getChildren();
        /*第一级评论排序*/
        sortComment(comments);
        /*第二级评论*/
        comments.stream().map(CommentPO::getChildren).forEach(this::sortComment);
        return new Result<>(comments, 0);
    }

    private void sortComment(List<CommentPO> comments) {
        /*优先按时间排序*/
        comments.sort((c1, c2) -> c2.getCreateTime().compareTo(c1.getCreateTime()));
        /*再按点赞数量排序*/
        comments.sort((c1, c2) -> c2.getLikeNum().compareTo(c1.getLikeNum()));
    }

    @Override
    public void deleteComment(DeleteCommentDTO commentDTO, UserInfoPO userInfo) {

        commentDTO.setUserId(userInfo.getId());
        /*检查必填字段是否为空*/
        commentDTO.checkProperty();
        /*删除*/
        commentMapper.deleteComment(commentDTO);
    }

    @Override
    public void giveLike(GiveCommentLikeDTO giveCommentLikeDTO, UserInfoPO userInfo) {
        /*设置ID*/
        giveCommentLikeDTO.setUserId(userInfo.getId());
        giveCommentLikeDTO.checkProperty();
        /*新增点赞*/
        commentMapper.giveLike(giveCommentLikeDTO);
    }

    @Override
    public void deleteLike(GiveCommentLikeDTO giveCommentLikeDTO, UserInfoPO userInfo) {

        giveCommentLikeDTO.setUserId(userInfo.getId());
        /*检查字段必填是否为空*/
        giveCommentLikeDTO.checkProperty();
        commentMapper.deleteLike(giveCommentLikeDTO);
    }
}
