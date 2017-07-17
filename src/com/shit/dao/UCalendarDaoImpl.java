package com.shit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shit.dto.UCalendar;

public class UCalendarDaoImpl implements UCalendarDao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url = "jdbc:oracle:thin:@192.168.0.27:1521:topcredu";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		return DriverManager.getConnection(url, "scott", "tiger");
//		return DriverManager.getConnection(url, "test2", "test2");
	}

	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UCalendar> select() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			StringBuffer sql = new StringBuffer(1024);
			sql.append("SELECT * FROM user_calendar WHERE (startdate >= TO_DATE('07/01/2017','MM/DD/YYYY') AND enddate < TO_DATE('07/03/2017','MM/DD/YYYY')) ");
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			List<UCalendar> cal = new ArrayList<>();
			while (rs.next()) {
				cal.add(setValues(rs));
			}
			return cal;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public int add(UCalendar calendar) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			StringBuffer sql = new StringBuffer(1024);
			sql.append("INSERT INTO user_calendar (id, title, tooltip, context, startdate, enddate) ");			
			sql.append("VALUES(id_seq.nextval, ?,?,?,to_date(?,'YY-MM-DD'),to_date(?,'YY-MM-DD'))");
//			sql.append("VALUES(?,?,?,?,?,?)");
			
			ps = conn.prepareStatement(sql.toString());
			setPs(ps, calendar);
			int affected = ps.executeUpdate();
			if(affected > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			return affected;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, null);
		}
		return 0;
	}

	@Override
	public int modify(UCalendar calendar) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			StringBuffer sql = new StringBuffer(1024);
			sql.append("UPDATE user_calendar SET title = ?, tooltip = ?, context = ?, startdate = ?, enddate = ? ");
			sql.append("WHERE id = ");
			sql.append(calendar.getId());

			ps = conn.prepareStatement(sql.toString());
			setPs(ps, calendar);

			int affected = ps.executeUpdate();

			if (affected > 0) {
				System.out.println("수정");
			} else {
				System.out.println("실패");
			}
			return affected;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, null);
		}
		return 0;
	}

	@Override
	public int remove(int id) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			StringBuffer sql = new StringBuffer(1024);
			sql.append("DELETE FROM user_calendar WHERE id =");
			sql.append(id);
			ps = conn.prepareStatement(sql.toString());
			int affected = ps.executeUpdate();

			if (affected > 0) {
				System.out.println("삭제");
			} else {
				System.out.println("실패");
			}
			return affected;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, null);
		}
		return 0;
	}

	@Override
	public List<UCalendar> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			StringBuffer sql = new StringBuffer(1024);
			sql.append("select * from user_calendar");
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			List<UCalendar> cal = new ArrayList<>();
			while (rs.next()) {
				cal.add(setValues(rs));
			}
			return cal;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<UCalendar> findById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from user_calendar where id =");
			sql.append(id);

			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			List<UCalendar> ucal = new ArrayList<>();
			while (rs.next()) {
				ucal.add(setValues(rs));
			}
			return ucal;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<UCalendar> findByTitle(String title) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			StringBuffer sql = new StringBuffer(1024);
			sql.append("select * from user_calendar where title like ");
			sql.append("'%"+title+"%'");
			
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			List<UCalendar> ucal = new ArrayList<>();
			while (rs.next()) {
				ucal.add(setValues(rs));
			}
			return ucal;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, rs);
		}
		return null;
	}
	
	private void setPs(PreparedStatement ps, UCalendar cal) {
		try {
//		   	ps.setInt(1, cal.getId());
		   	ps.setString(1, cal.getTitle());	   	
		   	ps.setString(2, cal.getTooltip());	   	
		   	ps.setString(3, cal.getContext());	   	
		   	ps.setString(4, cal.getStartdate());	   	
		   	ps.setString(5, cal.getEnddate());	   	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private UCalendar setValues(ResultSet rs) {
		UCalendar cal = new UCalendar();
		try {
			cal.setId(rs.getInt("id"));
			cal.setTitle(rs.getString("title"));        
	        cal.setTooltip(rs.getString("tooltip"));              
			cal.setContext(rs.getString("context"));   		
			cal.setStartdate(rs.getString("startdate").split(" ")[0]);
			cal.setEnddate(rs.getString("enddate").split(" ")[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cal;
	}

}
