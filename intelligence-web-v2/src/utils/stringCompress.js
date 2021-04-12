import pako from 'pako'
//解压
export function unzip(b64Data) {
  // // 将二进制字符串转换为字符数组
  // var charData = key.split('').map(function (x) { return x.charCodeAt(0); });
  // console.log('压缩后的文件大小:', charData.join(","))
  //
  // // 将数字数组转换成字节数组
  // var binData = new Uint8Array(charData);
  //
  // // 解压
  // var data = pako.inflate(binData);
  //
  // // 将GunZip ByTAREAR转换回ASCII字符串
  // key = String.fromCharCode.apply(null, new Uint16Array(data));
  //
  // //unescape(str)  --->解压后解码，防止中午乱码
  // return unescape(key);


  let strData = atob(b64Data);
  var charData = strData.split('').map(function (x) {
    return x.charCodeAt(0);
  });
  var binData = new Uint8Array(charData);
  var data = pako.inflate(binData);
  strData = String.fromCharCode.apply(null, new Uint16Array(data));
  return decodeURIComponent(strData);
}

//压缩
export function zip(str) {
  //escape(str)  --->压缩前编码，防止中午乱码
  var binaryString = pako.gzip(encodeURIComponent(str), { to: 'string' });
  return btoa(binaryString);;

}
