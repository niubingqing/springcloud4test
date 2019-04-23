//package com.bqniu.jpademo.calculator
//
//object HashCalculator {
//  def additiveHash(key: String, prime: Int): Int = {var hash = key.length; for (i <- key) hash += i; hash % prime}
//  def rotatingHash(key: String, prime: Int): Int = {var hash = key.length; for (i <- key) hash = (hash << 4) ^ (hash >> 28) ^ i; hash % prime }
//  def oneByOneHash(key: String):Int={var hash = key.length; for (i <- key) { hash += i;hash+=(hash << 10);hash+=hash >> 6;};hash += (hash << 3);  hash ^= (hash >> 11);hash += (hash << 15);hash}
//  def bernsteinHash(key: String):Int={var hash = key.length; for (i <- key) hash = 33 * hash + i;hash}
//  def universalHash(key:Array[Char],mask:Int,tab:Array[Int]):Int={var hash=key.length;for(i<- 0 until key.length<<3 by 8){ if((key(i>>3)& 0x01)==0) hash ^= tab(i + 0);if((key(i>>3)& 0x02)==0) hash ^= tab(i + 1);if((key(i>>3)& 0x04)==0) hash ^= tab(i + 2);if((key(i>>3)& 0x08)==0) hash ^= tab(i + 3);if((key(i>>3)& 0x10)==0) hash ^= tab(i + 4);if((key(i>>3)& 0x20)==0) hash ^= tab(i + 5);if((key(i>>3)& 0x40)==0) hash ^= tab(i + 6);if((key(i>>3)& 0x80)==0) hash ^= tab(i + 7);}; hash & mask }
//  def zobristHash(key:Array[Char],mask:Int,tab:Array[Array[Int]]):Int={var hash = key.length; for (i <- 0 until key.length) hash ^= tab(i)(key(i));hash&mask}
//  def fnvHash(data:Array[Byte]):Long={var hash= 2166136261L; for (i <- data)  hash = (hash ^ i) * 16777619;hash += hash << 13;hash ^= hash >> 7;hash += hash << 3;hash ^= hash >> 17;hash += hash << 5;hash }
//  def fnvHash(str:String):Long={var hash= 2166136261L; for (i <- str) hash = (hash ^ i) * 16777619;hash += hash << 13;hash ^= hash >> 7;hash += hash << 3;hash ^= hash >> 17;hash += hash << 5;hash }
//  def intHash(data:Int):Int={ var key=data; key +=  ~(key << 15);key ^= key >>> 10;key += key << 3;key ^= (key >>> 6);key += ~(key << 11);key ^= key >>> 16;key}
//  def rsHash(str:String):Int={var b = 378551;var a = 63689; var hash =0;for(i<-str){hash = hash * a + i;a=a*b;}  ;hash}
//  def jsHash(str:String):Int={var hash=1315423911;for(i<-str) hash ^= ((hash << 5) + i+ (hash >> 2)); hash}
//  def pjwHash(str:String):Long={val bitsInUnsignedInt = (4 * 8).toLong;val threeQuarters = ((bitsInUnsignedInt * 3) / 4).toLong;val oneEighth = (bitsInUnsignedInt / 8).toLong;val highBits = 0xFFFFFFFF.toLong << (bitsInUnsignedInt - oneEighth);var hash:Long = 0;var test:Long = 0;for(i<-str) {hash = (hash << oneEighth) + i;if ((test = hash & highBits) != 0) hash = (hash ^ (test >> threeQuarters)) & (~(highBits))}; hash }
//  def elfHash(str:String):Long={var x:Long=0;var hash:Long=0;for (i<- str) {hash = (hash << 4) + i; if ((x = hash & 0xF0000000L) != 0) hash ^= (x >> 24); hash &= ~x };hash}
//  def bkdrHash(str:String):Int={val seed= 131;var hash=0;for (i<- str) hash = (hash * seed) +i ;hash}
//  def sdbMHash(str:String):Int={ var hash=0;for (i<- str)  hash = i+ (hash << 6) + (hash << 16) - hash ;hash}
//  def djbHash(str:String):Int={var hash = 5381;for (i<- str) hash = ((hash << 5) + hash) + i; hash}
//  def dekHash(str:String):Int={var hash = str.length;for (i<- str) hash = ((hash << 5) ^ (hash >> 27)) ^ i; hash}
//  def apHash(str:String):Int={var hash = 0xAAAAAAAA;for(i<-0 until str.length) if((i & 1)== 0) hash ^= ((hash << 7) ^ str.charAt(i) * (hash >> 3)) else hash ^= (~((hash << 11) + str.charAt(i) ^ (hash >> 5)));hash}
//  def normalHash(str:String):Int={var h=0;if(str == null)  0 else (h = str.hashCode) ^ (h >>> 16)}
//
//  val additiveHash=(key: String, prime: Int) => {var hash = key.length; for (i <- key) hash += i; hash % prime}
//  val rotatingHash=(key: String, prime: Int)=> {var hash = key.length; for (i <- key) hash = (hash << 4) ^ (hash >> 28) ^ i; hash % prime }
//  val oneByOneHash=(key: String)=>{var hash = key.length; for (i <- key) { hash += i;hash+=(hash << 10);hash+=hash >> 6;};hash += (hash << 3);  hash ^= (hash >> 11);hash += (hash << 15);hash}
//  val bernsteinHash=(key: String)=>{var hash = key.length; for (i <- key) hash = 33 * hash + i;hash}
//  val universalHash=(key:Array[Char],mask:Int,tab:Array[Int])=>{var hash=key.length;for(i<- 0 until key.length<<3 by 8){ if((key(i>>3)& 0x01)==0) hash ^= tab(i + 0);if((key(i>>3)& 0x02)==0) hash ^= tab(i + 1);if((key(i>>3)& 0x04)==0) hash ^= tab(i + 2);if((key(i>>3)& 0x08)==0) hash ^= tab(i + 3);if((key(i>>3)& 0x10)==0) hash ^= tab(i + 4);if((key(i>>3)& 0x20)==0) hash ^= tab(i + 5);if((key(i>>3)& 0x40)==0) hash ^= tab(i + 6);if((key(i>>3)& 0x80)==0) hash ^= tab(i + 7);}; hash & mask }
//  val zobristHash=(key:Array[Char],mask:Int,tab:Array[Array[Int]])=>{var hash = key.length; for (i <- 0 until key.length) hash ^= tab(i)(key(i));hash&mask}
//  val fnvHash=(data:Array[Byte])=>{var hash= 2166136261L; for (i <- data)  hash = (hash ^ i) * 16777619;hash += hash << 13;hash ^= hash >> 7;hash += hash << 3;hash ^= hash >> 17;hash += hash << 5;hash }
//  val fnvHash=(str:String)=>{var hash= 2166136261L; for (i <- str) hash = (hash ^ i) * 16777619;hash += hash << 13;hash ^= hash >> 7;hash += hash << 3;hash ^= hash >> 17;hash += hash << 5;hash }
//  val intHash=(data:Int)=>{ var key=data; key +=  ~(key << 15);key ^= key >>> 10;key += key << 3;key ^= (key >>> 6);key += ~(key << 11);key ^= key >>> 16;key}
//  val rsHash=(str:String)=>{var b = 378551;var a = 63689; var hash =0;for(i<-str){hash = hash * a + i;a=a*b;}  ;hash}
//  val jsHash=(str:String)=>{var hash=1315423911;for(i<-str) hash ^= ((hash << 5) + i+ (hash >> 2)); hash}
//  val pjwHash=(str:String)=>{val bitsInUnsignedInt = (4 * 8).toLong;val threeQuarters = ((bitsInUnsignedInt * 3) / 4).toLong;val oneEighth = (bitsInUnsignedInt / 8).toLong;val highBits = 0xFFFFFFFF.toLong << (bitsInUnsignedInt - oneEighth);var hash:Long = 0;var test:Long = 0;for(i<-str) {hash = (hash << oneEighth) + i;if ((test = hash & highBits) != 0) hash = (hash ^ (test >> threeQuarters)) & (~(highBits))}; hash }
//  val elfHash=(str:String)=>{var x:Long=0;var hash:Long=0;for (i<- str) {hash = (hash << 4) + i; if ((x = hash & 0xF0000000L) != 0) hash ^= (x >> 24); hash &= ~x };hash}
//  val bkdrHash=(str:String)=>{val seed= 131;var hash=0;for (i<- str) hash = (hash * seed) +i ;hash}
//  val sdbMHash=(str:String)=>{ var hash=0;for (i<- str)  hash = i+ (hash << 6) + (hash << 16) - hash ;hash}
//  val djbHash=(str:String)=>{var hash = 5381;for (i<- str) hash = ((hash << 5) + hash) + i; hash}
//  val dekHash=(str:String)=>{var hash = str.length;for (i<- str) hash = ((hash << 5) ^ (hash >> 27)) ^ i; hash}
//  val apHash=(str:String)=>{var hash = 0xAAAAAAAA;for(i<-0 until str.length) if((i & 1)== 0) hash ^= ((hash << 7) ^ str.charAt(i) * (hash >> 3)) else hash ^= (~((hash << 11) + str.charAt(i) ^ (hash >> 5)));hash}
//  val normalHash=(str:String)=>{var h=0;if(str == null)  0 else (h = str.hashCode) ^ (h >>> 16)}
//
//
//  def buildCalculators(): Map[String, Object]  = {
//    val hashFuncMap: Map[String, Object] =Map(
//      ("additiveHash", additiveHash),
//      ("rotatingHash",rotatingHash),
//      ("oneByOneHash",oneByOneHash),
//      ("bernsteinHash",bernsteinHash),
//      ("universalHash",universalHash),
//      ("zobristHash",zobristHash),
//      ("fnvHash",fnvHash),
//      ("intHash",intHash),
//      ("rsHash",rsHash),
//      ("jsHash",jsHash),
//      ("pjwHash",pjwHash),
//      ("elfHash",elfHash),
//      ("bkdrHash",bkdrHash),
//      ("sdbMHash",sdbMHash),
//      ("djbHash",djbHash),
//      ("dekHash",dekHash),
//      ("apHash",apHash),
//      ("normalHash",normalHash))
//
//    return hashFuncMap
//  }
//}
