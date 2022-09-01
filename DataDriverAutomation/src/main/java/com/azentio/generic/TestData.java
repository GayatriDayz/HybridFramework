//package com.azentio.generic;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import org.json.JSONObject;
//import com.codoid.products.fillo.Connection;
//import com.codoid.products.fillo.Fillo;
//import com.codoid.products.fillo.Recordset;
//
//public class TestData {
//
//	public static Map readTestData(String dataFileName, String strTestCaseName) {
//		String StrdataFileName = System.getProperty("user.dir") + "\\TestArtifacts\\" + dataFileName;
//		HashMap dataMap = new HashMap();
//		String strQuery = "select * from data where Test_Case_Name = '" + strTestCaseName + "' ";
//
//		Fillo f = new Fillo();
//		Connection con;
//		try {
//			con = f.getConnection(StrdataFileName);
//			Recordset rs = con.executeQuery(strQuery);
//			while (rs.next()) {
//				for (int i = 0; i < rs.getFieldNames().size(); i++) {
//					String strColumnName = rs.getField(i).name();
//					String strColumnValue = rs.getField(i).value();
//					dataMap.put(strColumnName, strColumnValue);
//
//				}
//			}
//		} catch (Exception e) {
//
//		}
//
//		return dataMap;
//
//	}
//
//	public static HashMap<String, String> extractTestDataintoMap(String inputData) {
//		HashMap<String, String> inputMap = new HashMap<String, String>();
//
//		JSONObject json = new JSONObject(inputData);
//		Set<String> keys = json.keySet();
//
//		for (String key : keys) {
//			String strValue = (String) json.get(key);
//			inputMap.put(key, strValue);
//		}
//		return inputMap;
//	}
//}
//
//
//
