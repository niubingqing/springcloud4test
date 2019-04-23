package com.bqniu.jpademo

object JpaDemoAppliction {
  def main(args: Array[String]): Unit = {
    val p:String="select * from tablename where bak=0"
    p.split(' ').map(x=>x.toString)
  }
}
