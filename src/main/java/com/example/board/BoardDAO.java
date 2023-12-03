package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertBoard(BoardVO vo) {
        String sql = "insert into BOARD (category, title, writer, content) values ("
                + "" + vo.getCategory() + ","
                + "" + vo.getTitle() + ","
                + "" + vo.getWriter() + ","
                + "" + vo.getContent() + ")";
        return jdbcTemplate.update(sql);
    }

    public int deleteBoard(int seq) {
        String sql = "delete from BOARD where seq=" + seq;
        return jdbcTemplate.update(sql);
    }

    public int updateBoard(BoardVO vo) {
        String sql = "update BOARD set category=" + vo.getCategory() + ","
                                    + "title=" + vo.getTitle() + ","
                                    + "writer=" + vo.getWriter() + ","
                                    + "content=" + vo.getContent() + ","
                                    + "editdate=" + vo.getEditdate() + "where seq=" + vo.getSeq();

        return jdbcTemplate.update(sql);
    }

    class BoardRowMapper implements RowMapper<BoardVO> {
        @Override
        public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardVO vo = new BoardVO();
            vo.setSeq(rs.getInt("seq"));
            vo.setCategory(rs.getString("category"));
            vo.setTitle(rs.getString("title"));
            vo.setWriter(rs.getString("writer"));
            vo.setContent(rs.getString("content"));
            vo.setRegdate(rs.getDate("regdate"));
            vo.setEditdate(rs.getDate("editdate"));
            vo.setCnt(rs.getInt("cnt"));
//            System.out.println(vo.getContent());
            return vo;
        }
    }

    public BoardVO getBoard(int seq) {
        String sql = "select * from BOARD  where seq=" + seq;
        return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
    }
    public List<BoardVO> getBoardList() {
        String sql = "select * from BOARD order by seq desc";
        return  jdbcTemplate.query(sql, new BoardRowMapper());
    }
}
