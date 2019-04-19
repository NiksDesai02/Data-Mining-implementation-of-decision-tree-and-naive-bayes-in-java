package decisiontree_buildtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.IntStream;

public class DataSet {
	private String name;
	private String[][] data = null;
	private double entropy = 0;
	private HashMap<Feature, Double> infoGain = new HashMap<Feature, Double>();
	private Feature splitOnFeature = null;
	
	public DataSet(String name, String[][] data){
		this.name = name;
		this.data = data;
		//System.out.println(calculateEntropy().calculateInfoGain().findSplitOnfeature());
		calculateEntropy().calculateInfoGain().findSplitOnfeature();
	}
	
	private DataSet calculateEntropy(){
		new Feature(data,data[0].length-1).getFeatureValues().stream().forEach(featureValue -> 
			entropy += minusPlog2((double)featureValue.getOccurences()/(data.length-1)));
		//System.out.println(entropy);
		return this;
	}
	
	private DataSet calculateInfoGain(){
		IntStream.range(0, data[0].length-1).forEach(column -> {
			Feature feature = new Feature(data, column);
			ArrayList<DataSet> dataSets = new ArrayList<DataSet>();
			feature.getFeatureValues().stream().forEach(featureValue -> 
				dataSets.add(createDataSet(feature, featureValue, data)));
			double sum = 0;
			for(int i=0;i<dataSets.size();i++){
				sum += ((double)dataSets.get(i).getData().length-1)/(data.length-1)*dataSets.get(i).getEntropy(); 
			}
			infoGain.put(feature, entropy-sum);
		});
		return this;
	}
	
	private DataSet findSplitOnfeature(){
		Iterator<Feature> itr = infoGain.keySet().iterator();
		while(itr.hasNext()){
			Feature feature = itr.next();
			if(splitOnFeature == null) splitOnFeature = feature;
			if(infoGain.get(splitOnFeature) < infoGain.get(feature)) splitOnFeature = feature;; 
		}
		return this;
	}
	
	DataSet createDataSet(Feature feature, FeatureValue featureValue, String[][] data){
		int column = getColumnNumber(feature.getName());
		String[][] returnData = new String[featureValue.getOccurences()+1][data[0].length];
		returnData[0] = data[0];
		int count = 1;
		for(int i=1;i<data.length;i++){
			if(data[i][column] == featureValue.getName()) returnData[count++] = data[i];
		}
		return new DataSet(feature.getName() + ": " + featureValue.getName(), deleteColumn(returnData, column));
	}
	
	double minusPlog2(double p){
		double returnValue = 0;
		if(p!=(double)0)
			returnValue = (-1)*p*Math.log(p)/Math.log(2);
		return returnValue;
	}
	
	String[][] deleteColumn(String[][] data, int deleteColumn){
		String returnData[][] = new String[data.length][data[0].length-1];
		IntStream.range(0,data.length).forEach(row -> {
			int count = 0;
			for(int j=0;j<data[0].length;j++)
				if(j!=deleteColumn)
					returnData[row][count++] = data[row][j];
		});
		return returnData;
	}
	
	public int getColumnNumber(String columnName){
		int colNumber = -1;
		for(int j=0;j<data[0].length-1;j++){
			if(data[0][j] == columnName){
				colNumber = j;
				break;
			}
		}
		return colNumber;
	}
	
	public String[][] getData(){
		return data;
	}
	public double getEntropy(){
		return entropy;
	}
	public HashMap<Feature, Double> getInfoGain(){
		return infoGain;
	}
	public Feature getSplitOnFeature(){
		return splitOnFeature;
	}
	public String toString(){
		return name;
	}
}
