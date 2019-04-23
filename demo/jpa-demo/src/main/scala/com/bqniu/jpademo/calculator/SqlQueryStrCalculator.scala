//package com.bqniu.jpademo.calculator

//object SqlQueryStrCalculator {
//  def calculate(sql:String):Array[String]={
//    var opArray=sql.split(' ').map(x=> x.toString.trim).map(x=>if(x.equals("*")) "all" else x).map(x=>if(x.contains(',')) x.split(',') else x)
//    opArray
//  }
//}
