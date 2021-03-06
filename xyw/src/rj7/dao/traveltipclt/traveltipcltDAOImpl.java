package rj7.dao.traveltipclt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.traveltipclt;
import rj7.util.Connect;

public class traveltipcltDAOImpl implements ItraveltipcltCDAO {
	
	public boolean doCreate(traveltipclt t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance();
				Date date=new Date();				
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setCltt(time); 
		 		String sql = "insert into tbltraveltipclt" 
		 				+ "(ttid,cltid,cltdid,cltt )" 
		 				+"values(?,?,?,? )";			//sql��� 
				ArrayList <Object> param=new ArrayList();		//paramΪ�����б� 
				    param.add(t.getTtid());							//��param���� 
		 			param.add(t.getCltid()); 
					param.add(t.getCltdid());
					param.add(t.getCltt());
				    if(conn.update(sql, param)!=0){					//ִ��sql��䷵��ִ�н���� 
					flag = true; 
			    } 
			    return flag;									//��ӳɹ�flag=true,����flag=false 
		} 

	
	

	
	public Object findByid(String glid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ttid,cltid,cltdid,cltt"
				+ " from tbltraveltipclt where ttid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(glid);
		List<Object> rs = conn.queryForArrObject(sql, param,traveltipclt.class);
		if(rs.size()!=0){
			return rs.get(0);
		}
		else{
			return null;
		}
	}





	@Override
	public boolean doDelete(String glid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "delete from tbltraveltipclt where ttid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(glid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(traveltipclt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tbltraveltipclt set cltdid=?,"
				+ "cltid=?,cltt=?"+
				"where ttid = ?";							
			ArrayList<Object> param=new ArrayList();		
			param.add(t.getCltdid());						
			param.add(t.getCltid()); 
			param.add(t.getCltt());
			param.add(t.getTtid());
			
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	

}




