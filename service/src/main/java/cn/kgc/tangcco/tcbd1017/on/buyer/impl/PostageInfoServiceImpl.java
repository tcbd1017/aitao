package cn.kgc.tangcco.tcbd1017.on.buyer.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;

import cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1017.on.buyer.PostageInfoDao;
import cn.kgc.tangcco.tcbd1017.on.buyer.PostageInfoService;
import cn.kgc.tangcco.tcbd1017.on.pojo.Address;
import cn.kgc.tangcco.tcbd1017.on.pojo.PostageInfo;

/**
 * @author LIU KAI
 * @version 1.0 2019年12月14日 下午1:32:20 </br>
 */

public class PostageInfoServiceImpl implements PostageInfoService {
	private static PostageInfoDao postageInfoDao;
	private static ClassPathXmlApplicationContext path;
	static {
		path = new ClassPathXmlApplicationContext("ApplicationContext_on.xml");
		try {
			postageInfoDao = (PostageInfoDao) path.getBean(PostageInfoDao.class.getSimpleName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> queryPostageInfosByBuyerId(Map<String, Object> map) {
		Map<String, Object> info = new LinkedHashMap<String, Object>();
		info.put("msg", "");
		info.put("code", 0);
		info.put("data", new ArrayList<PostageInfo>());
		info.put("status", "failed");
		info.put("count", 0);
		try {
			int count = postageInfoDao.selectCountPostageInfoByBuyerId(map);
			if (count >= 10) {
				info.put("count", 10);
			}else {
				info.put("count", count);
			}
			List<PostageInfo> list = postageInfoDao.selectPostageInfosByBuyerId(map);
			if (list != null) {
				info.put("status", "success");
				info.put("data", list);
			}
			BaseDBUtils.closeAll();
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				BaseDBUtils.closeAll();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return info;
	}

	@Override
	public Map<String, Object> addPostageInfo(Map<String, Object> map) {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("status", "failed");
		// 新增前查看新增的状态是否是3（ 默认收件地址）
		try {
			BaseDBUtils.startTransaction();
			if (!ObjectUtils.isEmpty(map.get("postage_info_status")) && Integer.parseInt(map.get("postage_info_status").toString()) == 3) {
				// 开启事务
				// 查询该买家是否存在默认收件地址
				// 若存在 查到该信息
				PostageInfo postageInfo = postageInfoDao.selectPostageInfoByStatus(map);
				if (postageInfo != null) {
					postageInfo.setPostage_info_status(2);
					map.put("postageInfo", postageInfo);
					// 将该信息的状态改为普通地址
					int status = postageInfoDao.updatePostageInfosByStatus(map);
				}
			}
			// 添加收货信息表
			int postageInfoCount = postageInfoDao.insertPostageInfo(map);
			// 添加收货信息和买家中间表
			int buyerAndPostageInfoCount = postageInfoDao.insertbuyerAndPostageInfo(map);
			if (postageInfoCount > 0 && buyerAndPostageInfoCount > 0) {
				info.put("status", "success");
				BaseDBUtils.commitAndClose();
			}
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				BaseDBUtils.rollbackAndClose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return info;
	}

	@Override
	public Map<String, Object> modifyPostageInfo(Map<String, Object> map) {
		Map<String, Object> info = new LinkedHashMap<String, Object>();
		info.put("status", "failed");
		try {
			// 开启事务
			BaseDBUtils.startTransaction();
			// 查询该买家是否存在默认收件地址
			// 若存在 查到该信息
			PostageInfo postageInfo = postageInfoDao.selectPostageInfoByStatus(map);
			if (postageInfo != null) {
				postageInfo.setPostage_info_status(2);
				map.put("postageInfo", postageInfo);
				// 将该信息的状态改为普通地址
				int status = postageInfoDao.updatePostageInfosByStatus(map);

			}
			int postageInfoCount = postageInfoDao.updatePostageInfo(map);
			PostageInfo postageInfoo = postageInfoDao.selectPostageInfoByStatus(map);
			if (postageInfoo == null) {
				// 查询所有信息
				List<PostageInfo> buyerId = postageInfoDao.selectPostageInfosByBuyerId(map);
				// 获取第一个
				PostageInfo postageInfo2 = buyerId.get(0);
				postageInfo2.setPostage_info_status(3);
				map.put("postageInfo", postageInfo2);
				// 将它的状态修改为3
				postageInfoDao.updatePostageInfosByStatus(map);
			}
			if (postageInfoCount > 0) {
				info.put("status", "success");
				BaseDBUtils.commitAndClose();
				return info;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				BaseDBUtils.rollbackAndClose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return info;
	}

	@Override
	public Map<String, Object> modifyPostageInfosByStatus(Map<String, Object> map) {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("status", "failed");
		// 修改前查看修改的状态是否是3（ 默认收件地址）
		try {
			if (!ObjectUtils.isEmpty(map.get("postage_info_status")) && (int) map.get("postage_info_status") == 3) {
				// 开启事务
				BaseDBUtils.startTransaction();
				// 查询该买家是否存在默认收件地址
				// 若存在 查到该信息
				PostageInfo postageInfo = postageInfoDao.selectPostageInfoByStatus(map);
				System.out.println(postageInfo);
				if (postageInfo != null) {
					postageInfo.setPostage_info_status(2);
					map.put("postageInfo", postageInfo);
					// 将该信息的状态改为普通地址
					int status = postageInfoDao.updatePostageInfosByStatus(map);
				}
				map.put("postageInfo", "");
				int postageInfoCount = postageInfoDao.updatePostageInfosByStatus(map);
				if (postageInfoCount > 0) {
					info.put("status", "success");
					BaseDBUtils.commitAndClose();
					return info;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				BaseDBUtils.rollbackAndClose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return info;
	}

	@Override
	public Map<String, Object> removePostageInfosByStatus(Map<String, Object> map) {
		Map<String, Object> info = new LinkedHashMap<String, Object>();
		info.put("status", "failed");
		int postageInfoCount;
		try {
			BaseDBUtils.startTransaction();
			// 查询总记录数
			int count = postageInfoDao.selectCountPostageInfoByBuyerId(map);
			if (count > 1) {
				// 查询状态为3的信息
				PostageInfo postageInfo = postageInfoDao.selectPostageInfoByStatus(map);
				// 如果相同
				if (postageInfo.getPostage_info_id() == Integer.parseInt(map.get("postage_info_id").toString())) {
					// 执行删除
					postageInfoCount = postageInfoDao.updatePostageInfosByStatus(map);
					// 查询所有信息
					List<PostageInfo> buyerId = postageInfoDao.selectPostageInfosByBuyerId(map);
					// 获取第一个
					PostageInfo postageInfo2 = buyerId.get(0);
					postageInfo2.setPostage_info_status(3);
					map.put("postageInfo", postageInfo2);
					// 将它的状态修改为3
					postageInfoDao.updatePostageInfosByStatus(map);
				} else {
					// 直接执行删除
					postageInfoCount = postageInfoDao.updatePostageInfosByStatus(map);
				}
			} else {
				// 直接执行删除
				postageInfoCount = postageInfoDao.updatePostageInfosByStatus(map);
			}
			if (postageInfoCount > 0) {
				info.put("status", "success");
				BaseDBUtils.commitAndClose();
				return info;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				BaseDBUtils.rollbackAndClose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return info;
	}

	@Override
	public Map<String, Object> findAddressById(Map<String, Object> map) {
		Map<String, Object> info = new LinkedHashMap<String, Object>();
		info.put("msg", "");
		info.put("code", 0);
		info.put("data", new Address());
		info.put("status", "failed");
		try {
			Address address = postageInfoDao.selectAddress(map);
			if (address != null) {
				info.put("data", address);
				info.put("status", "success");
			}
			BaseDBUtils.closeAll();
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				BaseDBUtils.closeAll();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return info;
	}

	@Override
	public Map<String, Object> queryAddressesByPid(Map<String, Object> map) {
		Map<String, Object> info = new LinkedHashMap<String, Object>();
		info.put("msg", "");
		info.put("code", 0);
		info.put("data", new ArrayList<Address>());
		info.put("status", "failed");
		try {
			List<Address> addressList = postageInfoDao.selectAllAddress(map);
			if (addressList != null) {
				info.put("data", addressList);
				info.put("status", "success");
			}
			BaseDBUtils.closeAll();
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				BaseDBUtils.closeAll();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return info;
	}

	@Override
	public Map<String, Object> queryOrderByOrderUuid(Map<String, Object> map) {
		Map<String, Object> info = new LinkedHashMap<String, Object>();
		info.put("msg", "");
		info.put("code", 0);
		info.put("data", new HashMap<String, Object>());
		info.put("status", "failed");
		try {
			Map<String, Object> order = postageInfoDao.selectOrderByOrderUuid(map);
			if (order != null) {
				info.put("data", order);
				info.put("status", "success");
			}
			BaseDBUtils.closeAll();
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				BaseDBUtils.closeAll();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return info;
	}

	@Override
	public Map<String, Object> querySellerByBuyer_id(Map<String, Object> map) {
		Map<String, Object> info = new LinkedHashMap<String, Object>();
		info.put("msg", "");
		info.put("code", 0);
		info.put("data", new HashMap<String, Object>());
		info.put("status", "failed");
		try {
			Map<String, Object> seller = postageInfoDao.selectSellerByBuyer_id(map);
			if (seller != null) {
				info.put("data", seller);
				info.put("status", "success");
			}
			BaseDBUtils.closeAll();
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				BaseDBUtils.closeAll();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return info;
	}

}
