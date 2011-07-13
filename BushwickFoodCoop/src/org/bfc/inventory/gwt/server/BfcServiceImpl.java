package org.bfc.inventory.gwt.server;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Date;

import javax.servlet.ServletException;

import org.bfc.inventory.gwt.client.service.BfcService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class BfcServiceImpl extends RemoteServiceServlet implements BfcService {
	private static final long serialVersionUID = 3095611915792306775L;

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	
	@Override
	public String parseAppendInventorySpreadsheet(String inventoryText) throws Exception {
		return this.parseInventorySpreadsheet(inventoryText);
	}


	@Override
	public String parseResetInventorySpreadsheet(String inventoryText) throws Exception {
		String parsedInventorySpreadsheet = this.parseInventorySpreadsheet(inventoryText);
		
		StringBuffer out = new StringBuffer();
		out.append("delete from `private_bfc`;\n");
		out.append(parsedInventorySpreadsheet);
		
		return out.toString();
	}
	
	
	public String parseInventorySpreadsheet(String inventoryText) throws Exception {
		StringBuffer out = new StringBuffer();		
		BufferedReader in = new BufferedReader(new StringReader(inventoryText));
		try{
			String line;
			while((line = in.readLine()) != null){
				String[] toks = line.split("\t");
				
				if(toks.length < 15){
					out.append("Invalid: "+line+"\n");
					continue;
				}
				
				if(toks[0].trim().equalsIgnoreCase("code")){
					continue;
				}
				
				InventoryRow inventoryRow = new InventoryRow(toks);
				out.append(inventoryRow.constructInsertStatement()+"\n");
				
			}	
		}finally{
			in.close();
		}	
		
		return out.toString();
	}
	
	
	private static class InventoryRow{
		private final String code;
		private final String category;
		private final String subCategory;
		private final String manufacturer;
		private final String description;
		private final String short_description = null;
		private final String size;
		private final Double price;
		private final Double sale_price;
		private final Double price_per_weight;
		private final Integer is_priced_by_weight;
		private final Integer taxed=0;
		private final String origin;
		private final Integer num_available;
		private final Double valid_order_increment;
		private final Double valid_split_increment=1.0;
		private final String last_updated_by=null;
		private final Date last_ordered=null;
		
		public InventoryRow(String[] toks) throws Exception{
			super();
			
			
			/*
			 *Code	0
Category	1
sub_category	2
manufacturer	3
description	4
origin	5
size	6
Order price	7
minimum_purchase	8
Price per Item	9
price	10
sale_price	11
is_priced_by_weight	12
num_available	13
valid_order_increment	14
Order #	15
Split?	16
			 */
			//int idx = 0;
			code = formatString(toks[0]);
			category = formatString(toks[1]);
			subCategory = formatString(toks[2]);
			manufacturer = formatString(toks[3]);
			description = formatString(toks[4]);
			origin = formatString(toks[5]);
			size = formatString(toks[6]);
			price = formatDouble(toks[10]);
			sale_price = formatDouble(toks[11]);
			price_per_weight = formatDouble(toks[9]);
			is_priced_by_weight = formatInteger(toks[12]);
			num_available = formatInteger(toks[13]);
			valid_order_increment = formatDouble(toks[14]);
		}
		
		
		public String constructInsertStatement(){
			String retVal = "insert into `private_bfc` (valid_split_increment, " +
					"valid_order_increment, taxed, size, short_description, sale_price, " +
					"price_per_weight, price, origin, num_available, manufacturer, last_updated_by, " +
					"last_ordered, is_priced_by_weight, description, code, category, sub_category,num_orders, case_units, case_weight, " +
					"each_size, last_updated,  retail_price,  sub_category2, " +
					"unit_price, unit_weight, upc, valid_price) values (";
			
			retVal += formatInsertArgument(this.valid_split_increment)+", ";
			retVal += formatInsertArgument(this.valid_order_increment)+", ";
			retVal += formatInsertArgument(this.taxed)+", ";
			retVal += formatInsertArgument(this.size)+", ";
			retVal += formatInsertArgument(this.short_description)+", ";
			retVal += formatInsertArgument(this.sale_price)+", ";
			retVal += formatInsertArgument(this.price_per_weight)+", ";
			retVal += formatInsertArgument(this.price)+", ";
			retVal += formatInsertArgument(this.origin)+", ";
			retVal += formatInsertArgument(this.num_available)+", ";
			retVal += formatInsertArgument(this.manufacturer)+", ";
			retVal += formatInsertArgument(this.last_updated_by)+", ";
			retVal += formatInsertArgument(this.last_ordered)+", ";
			retVal += formatInsertArgument(this.is_priced_by_weight)+", ";
			retVal += formatInsertArgument(this.description)+", ";
			retVal += formatInsertArgument(this.code)+", ";
			retVal += formatInsertArgument(this.category)+", ";
			retVal += formatInsertArgument(this.subCategory)+", ";
			retVal += "1, null, null, null, null, null, null, null, null, null, null) ON DUPLICATE KEY UPDATE last_updated = null;";

			return retVal;
		}
		
		
		private static String formatInsertArgument(Object arg){
			if (arg == null){
				return "NULL";
			}else if (arg instanceof String){
				return "'"+arg.toString()+"'";
			}
			
			return arg.toString();
		}
		
		private static String formatString(String arg){
			if(arg == null || arg.trim().length() <= 0){
				return null;
			}
			
			
			return arg.trim().replaceAll("\\'", "\\\\'");
		}
		
		private static Double formatDouble(String tok) throws Exception{
			if(tok == null || tok.trim().length()<= 0){
				return null;
			}
		
			return Double.parseDouble(tok);
		}
		
		private static Integer formatInteger(String tok) throws Exception{
			if(tok == null || tok.trim().length()<= 0){
				return null;
			}
		
			return Integer.parseInt(tok);
		}
		
		
	}

}
