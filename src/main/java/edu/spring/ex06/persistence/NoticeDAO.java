package edu.spring.ex06.persistence;

import java.util.List;

import edu.spring.ex06.domain.NoticeVO;
import edu.spring.ex06.pageutil.PageCriteria;



public interface NoticeDAO {
   public abstract int insert(NoticeVO vo);
   public abstract List<NoticeVO> select();
   public abstract NoticeVO select(int noticeNo);
   public abstract int update(NoticeVO vo);
   public abstract int delete(int noticeNo);
   public abstract List<NoticeVO> select(PageCriteria c);
   public abstract int getTotalNumsOfRecords();
   public abstract List<NoticeVO> select(String userid);
   public abstract List<NoticeVO> selectByTitleOrContent(String keyword);
}