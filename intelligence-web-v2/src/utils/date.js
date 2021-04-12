// date.js
export function formatDate(date, fmt) {
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
  }
  let o = {
    'M+': date.getMonth() + 1,
    'd+': date.getDate(),
    'h+': date.getHours(),
    'm+': date.getMinutes(),
    's+': date.getSeconds()
  };
  for (let k in o) {
    if (new RegExp(`(${k})`).test(fmt)) {
      let str = o[k] + '';
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
    }
  }
  return fmt;
}

function padLeftZero(str) {
  return ('00' + str).substr(str.length);
}

export function getWeekDay(time) {
  var weekArray = new Array("星期日","星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
  var week  = weekArray[new Date(time).getDay()];
  return week;
}

export function parse(time) {
  var date = new Date(time);
  return date.getFullYear() + '-' + checkTime(date.getMonth() + 1) + '-' + checkTime(date.getDate());
}

function checkTime(i) {
  if (i < 10) {
    i = '0' + i
  }
  return i

}

export function str2Date(dateStr, separator) {
  if (!separator) {
    separator = "-";
  }
  let dateArr = dateStr.split(separator);
  let year = parseInt(dateArr[0]);
  let month;
  //处理月份为04这样的情况
  if (dateArr[1].indexOf("0") == 0) {
    month = parseInt(dateArr[1].substring(1));
  } else {
    month = parseInt(dateArr[1]);
  }
  let day = parseInt(dateArr[2]);
  let date = new Date(year, month - 1, day);
  return date;
}

export function getWeekFirst(){
  let nowData = new Date();
  let currentDay = nowData.getDay();
  let sunDayTime = nowData.getTime() - currentDay * 24 * 60 * 60 * 1000;
  return new Date(sunDayTime)
}

/**
 * 构造树型结构数据
 * @param {*} data 数据源
 * @param {*} id id字段 默认 'id'
 * @param {*} parentId 父节点字段 默认 'parentId'
 * @param {*} children 孩子节点字段 默认 'children'
 * @param {*} rootId 根Id 默认 0
 */
export function handleTree(data, id, parentId, children, rootId) {
  id = id || 'Id'
  parentId = parentId || 'parentId'
  children = children || 'children'
  rootId = rootId || Math.min.apply(Math, data.map(item => { return item[parentId] })) || 0
  //对源数据深度克隆
  const cloneData = JSON.parse(JSON.stringify(data))
  //循环所有项
  const treeData = cloneData.filter(father => {
    let branchArr = cloneData.filter(child => {
      //返回每一项的子级数组
      return father[id] === child[parentId]
    });
    branchArr.length > 0 ? father.children = branchArr : '';
    //返回第一层
    return father[parentId] === rootId;
  });
  return treeData != '' ? treeData : data;
}
// 回显数据字典
export function selectDictLabel(datas, value) {
  var actions = [];
  Object.keys(datas).some((key) => {
    if (key == ('' + value)) {
      actions.push(datas[key]);
      return true;
    }
  })
  return actions.join('');
}
// 添加日期范围
export function addDateRange(params, dateRange, propName) {
  var search = params;
  search.startTime = undefined;
  search.endTime = undefined;
  if (null != dateRange && '' != dateRange) {
    if (typeof(propName) === "undefined") {
      search.startTime = dateRange[0];
      search.endTime = dateRange[1];
    } else {
      search.propName = dateRange[0];
      search.propName = dateRange[1];
    }
  }
  return search;
}
