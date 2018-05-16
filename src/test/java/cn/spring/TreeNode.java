package cn.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

public class TreeNode {

	class Node {
		private Integer id;
		private Integer parentId;
		private String name;
		private Integer size;// 分享好友矿机激活数量
		private Boolean active;//
		public double machine_income_fee;//

		public Node(Integer id, Integer parentId, String name) {
			super();
			this.id = id;
			this.parentId = parentId;
			this.name = name;
		}

		public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}

		public Integer getSize() {
			return size;
		}

		public void setSize(Integer size) {
			this.size = size;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getParentId() {
			return parentId;
		}

		public void setParentId(Integer parentId) {
			this.parentId = parentId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	class NodeVO extends Node {

		// 分销关系
		public NodeVO(Integer id, Integer parentId, String name) {
			super(id, parentId, name);
		}

		private List<NodeVO> children;

		public List<NodeVO> getChildren() {
			return children;
		}

		public void setChildren(List<NodeVO> children) {
			this.children = children;
		}

		@Override
		public String toString() {
			return "{id:" + super.id + ",parentId:" + super.parentId + ",name:" + super.name + "}";
		}

	}

	/**
	 * 将List重组为数
	 * 
	 * @param taskDTOList
	 *            DTO集合
	 * @return List<XMGLTaskDTO>
	 */
	public List<NodeVO> constructTaskDTOToTree(List<NodeVO> taskDTOList) {
		// key:父节点ID value:子节点集合
		Map<Integer, List<NodeVO>> taskDTOMap = new HashMap<>();

		// 将List重组到Map中
		taskDTOList.forEach(dto -> {
			List<NodeVO> tempTaskDTOList = taskDTOMap.get(dto.getParentId());
			if (tempTaskDTOList == null) {
				tempTaskDTOList = new ArrayList<NodeVO>();
				// 亲节点-children 该map的子节点为空(初期化)
				taskDTOMap.put(dto.getParentId(), tempTaskDTOList);
			}
			// 本身即为子节点(顶级节点亦加入)
			tempTaskDTOList.add(dto);
		});

		// 所有顶级节点集合
		List<NodeVO> resultTaskDTOList = taskDTOMap.get(null);

		recurTaskDTOList(resultTaskDTOList, taskDTOMap);

		return resultTaskDTOList;
	}

	/**
	 * 将重组好的Map进行树形结构处理
	 * 
	 * @param taskDTOList
	 *            父节点集合(不一定是顶级节点 因为会递归调用)
	 * @param sourceMap
	 *            组装好的Map集合
	 */
	public void recurTaskDTOList(List<NodeVO> taskDTOList, Map<Integer, List<NodeVO>> sourceMap) {
		if (CollectionUtils.isEmpty(taskDTOList))
			return;
		taskDTOList.forEach(dto -> {
			dto.setChildren(sourceMap.get(dto.getId()));
			recurTaskDTOList(dto.getChildren(), sourceMap);
		});
	}

	
	//分享收益计算
	// 外部定义
	// level =1
	// amount
	// 递归算法
	public double recourCanculate(double amount, int level, int controlSize, NodeVO nodeVO,
			Map<Integer, Double> mapLevel) {
		// level default==1
		// amount = 0 代数确认
		// controlSize = nodeVo.getSize()
		if (level <= 10 && level <= controlSize) {
			List<NodeVO> childNodeList = nodeVO.getChildren();

			for (NodeVO node : childNodeList) {
				if (node.getActive()) {
					amount += 5 * mapLevel.get(level);
				}
			}
			level++;
			for (NodeVO node : childNodeList) {
				if (node.getActive()) {
					recourCanculate(amount, level, controlSize, node, mapLevel);
				}
			}

		}

		return 0.00;
	}


	public static void main(String[] args) {
		List<NodeVO> taskDTOList = new ArrayList<>();
		taskDTOList.add(new TreeNode().new NodeVO(1, null, "a"));
		taskDTOList.add(new TreeNode().new NodeVO(2, 1, "b"));
		taskDTOList.add(new TreeNode().new NodeVO(3, 1, "c"));
		taskDTOList.add(new TreeNode().new NodeVO(4, 2, "d"));

		List<NodeVO> tree = new TreeNode().constructTaskDTOToTree(taskDTOList);

		tree.forEach(o -> {
			System.out.println(o);
			if (o.getChildren() != null) {
				o.getChildren().forEach(p -> {
					System.out.println(p);
					if (p.getChildren() != null) {
						p.getChildren().forEach(q -> {
							System.out.println(q);
						});
					}
				});
			}
		});

	}

}
