package decisiontree_buildtree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Driver extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	static String[][] weather = 
		   {{"outlook","temprature","humidity","windy","play"},
			{"sunny","hot","high","FALSE","no"},
			{"sunny","hot","high","TRUE","no"},
			{"overcast","hot","high","FALSE","yes"},
			{"rainy","mild","high","FALSE","yes"},
			{"rainy","cool","normal","FALSE","yes"},
			{"rainy","cool","normal","TRUE","no"},
			{"overcast","cool","normal","TRUE","yes"},
			{"sunny","mild","high","FALSE","no"},
			{"sunny","cool","normal","FALSE","yes"},
			{"rainy","mild","normal","FALSE","yes"},
			{"sunny","mild","normal","TRUE","yes"},
			{"overcast","mild","high","TRUE","yes"},
			{"overcast","hot","normal","FALSE","yes"},
			{"rainy","mild","high","TRUE","no"}};
	
	static Map<String, String[][]> datas = Collections.unmodifiableMap(new HashMap<String, String[][]>() {
		private static final long serialVersionUID = 1L;
		{
			put("weather",weather);
		}
	});
	static String dataKey = datas.keySet().iterator().next();
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		JTree tree = null;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		//System.out.println(weather[0]);
		while(flag){
			System.out.println("1. Build Tree");
			System.out.println("2. Exit");
			System.out.println("Enter your choice :: ");
			int choice = scan.nextInt();
			switch(choice){
				case 1:
					DataSet dataSet = new DataSet(dataKey, datas.get(dataKey));
					DefaultMutableTreeNode node = new DefaultMutableTreeNode(dataSet.getSplitOnFeature().getName());
					driver.processDataSet(dataSet, node, "");
					if(tree!=null) driver.remove(tree);
					tree = new JTree(node);
					driver.add(tree);
					driver.setSize(500,500);
					driver.setTitle(dataKey+" DataSet");
					driver.setVisible(true);
					break;
				case 2:
					flag = false;
					System.out.println("SEE YOU SOON...");
					break;
			}
		}
		System.exit(0);
	}
	
	void processDataSet(DataSet dataSet, DefaultMutableTreeNode node, String featureValueName){
		if(dataSet.toString() != null) System.out.println(dataSet);
		if(dataSet.getEntropy() !=0){
			System.out.println("Best feature to split is : " + dataSet.getSplitOnFeature() + " " + dataSet.getSplitOnFeature().getFeatureValues());	
			HashMap<String, DataSet> featureDataSets = new HashMap<String, DataSet>();
			dataSet.getSplitOnFeature().getFeatureValues().forEach(featureValue ->
					featureDataSets.put(featureValue.getName(), dataSet.createDataSet(dataSet.getSplitOnFeature(), featureValue, dataSet.getData())));
			processDataSets(featureDataSets, node);
		}
		else{
			String[][] data = dataSet.getData();
			String decision = " [" + data[0][data[0].length-1] + " = " + data[1][data[0].length-1] + "]";
			node.add(new DefaultMutableTreeNode(featureValueName + " : " + decision));
			System.out.println("Decision ==> " + decision);
		}
	}
	void processDataSets(HashMap<String, DataSet> dataSets, DefaultMutableTreeNode node){
		dataSets.keySet().forEach(dataSet -> {
			if(dataSets.get(dataSet).getEntropy() != 0){
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(dataSet + " : [" + dataSets.get(dataSet).getSplitOnFeature().getName() + "]");
				node.add(newNode);
				processDataSet(dataSets.get(dataSet), newNode, dataSet);
			}
			else 
				processDataSet(dataSets.get(dataSet), node, dataSet);
		});
	}
}
