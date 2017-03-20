import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JTextArea;
class Line
{
    private int lineno;
    private String line_descrip;
   
    Line()
    {
        setLineno(0);
        setLine_descrip("");
    }

    public String getLine_descrip() {
        return line_descrip;
    }

    public void setLine_descrip(String line_descrip) {
        this.line_descrip = line_descrip;
    }

    public int getLineno() {
        return lineno;
    }

    public void setLineno(int lineno) {
        this.lineno = lineno;
    }
}
   
class Node
{
    private int node_no;
    private String node_descrip;
    private int type;
    private Node true_part;
    private Node else_part;
   
    Node(int node_no, String node_descrip,int type)
    {
        this.setNode_no(node_no);
        this.setNode_descrip(node_descrip);
        this.setType(type);
        this.true_part=null;
        this.else_part=null;
    }

    public int getNode_no() {
        return node_no;
    }

    public void setNode_no(int node_no) {
        this.node_no = node_no;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNode_descrip() {
        return node_descrip;
    }

    public void setNode_descrip(String node_descrip) {
        this.node_descrip = node_descrip;
    }

    public Node getTrue_part() {
        return true_part;
    }

    public void setTrue_part(Node true_part) {
        this.true_part = true_part;
    }

    public Node getElse_part() {
        return else_part;
    }

    public void setElse_part(Node else_part) {
        this.else_part = else_part;
    }
   
}

class LineFile
{
    private ArrayList<Line> lines = new ArrayList<Line>();
   
    public void makeLines(File f)
    {
        int count = 1;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found");
            return;
        }
        System.out.println("Fileherehererere");
        try
        {
            String sentn, s1;
            while ((sentn = br.readLine()) != null)
            {
                //textArea.append(sentn+"\n");
            	s1 = sentn.toUpperCase();
                Line x = new Line();
                x.setLineno(count);
                x.setLine_descrip(s1);
                lines.add(x);
                count++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void dispLines(File f, JTextArea textArea)
    {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found");
            return;
        }
        try
        {
            String sentn;
            while ((sentn = br.readLine()) != null)
            {
                textArea.append(sentn+"\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void errorCheck(JTextArea textArea)
    {
    	Iterator<Line> itr = lines.iterator();
    	Stack<String> ifstack = new Stack<String>();
		Stack<String> whilestack=new Stack<String>();
		int check = 0;
    	String line;
    	while(itr.hasNext()){
    		System.out.println("good");
			line = itr.next().getLine_descrip();
			if(line.contains("IF")&&!line.contains("END"))
			{
				ifstack.push("if");
				}
			if(line.contains("WHILE")&&!line.contains("END"))
			{
				whilestack.push("while");
			}
			if(line.contains("ENDIF"))
			{
				if(ifstack.empty())
				{
					textArea.append("EndIf without If in line\n");
					check=1;
				}
				else
				 ifstack.pop();
			}
			if(line.contains("ENDWHILE"))
			{
				if(whilestack.empty())
				{
					textArea.append("EndWhile without While in line\n");
					check=1;
				}
				else
				whilestack.pop();
			}
			if(line.contains("ELSE"))
			{
			    if(ifstack.empty())
			    {
			    	textArea.append("Else Without If in line\n");
			    	check=1;
			    }
			}
			if(line.contains("THEN")&&(!(line.contains("IF"))))
			{
				textArea.append("Then without If in line\n");
				check=1;
			}
		}
		if(!ifstack.empty())
		{
			textArea.append("Unclosed If \n");
			check=1;
		}
		if(!whilestack.empty())
		{
			textArea.append("Unclosed While \n");
			check=1;
		}
		else if(check==0)
		{
			System.out.println("good");
			textArea.append("No errors \n");
		}
    }
    public ArrayList<Line> getLines() {
        return lines;
    }

   
    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }
}

class Table1
{
	private String actiono;
	private int lineno;
	private String actionname;
	static int count=1;
	Table1(int lineno2,String actionname2,int flag){
		this.setLineno(lineno2);
		this.setActioname(actionname2);
		if(flag==1){
			actiono = "A"+count;
			count++;
		}
		else{
			actiono="";
		}
	}
	public String getActiono() {
		return actiono;
	}
	public void setActiono(String actiono) {
		this.actiono = actiono;
	}
	public int getLineno() {
		return lineno;
	}
	public void setLineno(int lineno) {
		this.lineno = lineno;
	}
	public String getActioname() {
		return actionname;
	}
	public void setActioname(String actionname) {
		this.actionname = actionname;
	}
	
}

class Table2{
	static int count=1;
	private int sno;
	private int lineno;
	private String actionno;
	private String lineaction;
	Table2(int lineno2,String actiono2,String lineaction2){
		this.lineno=lineno2;
		this.actionno=actiono2;
		this.lineaction=lineaction2;
		this.sno=count;
		count++;
	}
	public int getLineno() {
		return lineno;
	}
	public void setLineno(int lineno) {
		this.lineno = lineno;
	}
	public String getLineaction() {
		return lineaction;
	}
	public void setLineaction(String lineaction) {
		this.lineaction = lineaction;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getActionno() {
		return actionno;
	}
	public void setActionno(String actionno) {
		this.actionno = actionno;
	}
	
}

class Table3{
	private int lineno;
	Table3(int lineno2){
		this.setLineno(lineno2);
	}
	public int getLineno() {
		return lineno;
	}
	public void setLineno(int lineno) {
		this.lineno = lineno;
	}
	
}

public class Flow
{
   
    /*public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> whileSet = new ArrayList<Integer>();
        ArrayList<Integer> lpkount = new ArrayList<Integer>();
        LineFile l1 = new LineFile();
        int i;
        Node startNode;
        //
        l1.makeLines();
        Flow f = new Flow();
        startNode = f.createUseCaseGraph(l1.getLines(), whileSet);
        ArrayList<String> str = f.generateScenarios(startNode, 1);
        f.print(str,startNode);
        for(i = 0; i < whileSet.size(); i++)
        {
            System.out.println("\nEnter number of iterations of loop "+(i+1)+": ");
            lpkount.add(sc.nextInt());
        }
 
        str = f.generateScenarios2(startNode, lpkount, whileSet);
        f.print(str,startNode);
    }**/
    public Node createUseCaseGraph(ArrayList<Line> linf, ArrayList<Integer> whileSet, ArrayList<Table1> table1array,ArrayList<Table3> table3array ) {
        Node startNode = new Node(0,"Start",0);
        Node endNode = new Node(1000,"Start",20);
        endNode.setTrue_part(null);
        Node currentNode = startNode;
        Iterator<Line> li = linf.iterator();
        Stack<Node> ifstack = new Stack<Node>();
        Stack<Node> whilestack = new Stack<Node>();
        Stack<Node> lastvisitstack = new Stack<Node>();
        Table1 table1;
        Table3 table3;
        while (li.hasNext()){
            Line ln = li.next();
            if (ln.getLine_descrip().startsWith("IF")) {
                Node n = new Node(ln.getLineno(),ln.getLine_descrip(),2);
                ifstack.push(n);
                currentNode.setTrue_part(n);
                currentNode = n;
                table1= new Table1(ln.getLineno(),"IF",1);
                table1array.add(table1);
                table3 = new Table3(ln.getLineno());
                table3array.add(table3);
            }
            else if (ln.getLine_descrip().startsWith("ELSE")) {
                Node n = new Node(ln.getLineno(),ln.getLine_descrip(),3);
                if (!ifstack.isEmpty()){
                    ifstack.pop().setElse_part(n);
                    table1= new Table1(ln.getLineno(),"ELSE",0);
                    table1array.add(table1);
                }
                
                else {
                    System.out.print("Error1");
                }
                lastvisitstack.push(currentNode);
                currentNode = n;
            }
            else if (ln.getLine_descrip().startsWith("ENDIF")) {
                Node n = new Node(ln.getLineno(),ln.getLine_descrip(),4);
                currentNode.setTrue_part(n);
                if (!lastvisitstack.isEmpty()){
                lastvisitstack.pop().setTrue_part(n); 
                table1= new Table1(ln.getLineno(),"ENDIF",0);
                table1array.add(table1);
                }
                else {
                    System.out.print("Error2");
                }
                currentNode = n;
            }
           
            else if (ln.getLine_descrip().startsWith("WHILE")) {
                Node n = new Node(ln.getLineno(),ln.getLine_descrip(),5);
                whilestack.push(n);
                currentNode.setTrue_part(n);
                currentNode = n;
                whileSet.add(ln.getLineno()+1);
                System.out.printf("here while \n");
                table1= new Table1(ln.getLineno(),"WHILE",1);
                table1array.add(table1);
            }
            else if (ln.getLine_descrip().startsWith("ENDWHILE")) {
                Node n = new Node(ln.getLineno(),ln.getLine_descrip(),6);
                if (!whilestack.isEmpty()){
                    Node w =whilestack.pop();
                    w.setElse_part(n);
                    currentNode.setTrue_part(w);
                    currentNode = n;
                    table1= new Table1(ln.getLineno(),"ENDWHILE",0);
                    table1array.add(table1);
                }
                else {
                    System.out.print("Error4");
                }
              
            }
            else if (ln.getLine_descrip().startsWith("END")) {
                if (whilestack.isEmpty() && ifstack.isEmpty()){
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),7);
                    currentNode.setTrue_part(n);
                    currentNode = n;
                    n.setTrue_part(endNode);
                    table1= new Table1(ln.getLineno(),"END",1);
                    table1array.add(table1);
                }
                else {
                    System.out.print("Error5");
                }
            }
            else if (ln.getLine_descrip().startsWith("EXIT")) {
                if (currentNode.getType()==5){
                    currentNode.setElse_part(endNode);
                }
                else if (currentNode.getType()==3){
                    currentNode.setElse_part(endNode);
                }
                else {
                    currentNode.setTrue_part(endNode);
                }
                table1= new Table1(ln.getLineno(),"EXIT",1);
                table1array.add(table1);
            }
            else {
                Node n = new Node(ln.getLineno(),ln.getLine_descrip(),1);
                currentNode.setTrue_part(n);
                currentNode = n;
                table1= new Table1(ln.getLineno(),ln.getLine_descrip(),1);
                table1array.add(table1);
            }
        }
        /*Iterator<String> itr = whileSet.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }**/
        System.out.println("1THIS-> "+startNode);
        return startNode;
    }
    public void print(ArrayList<String> str,Node start)
    {
       
        int i = 1;
        Iterator<String> itr = str.iterator();
        while(itr.hasNext())
        {
            System.out.println("Scenario no. "+i+": "+itr.next());
            i++;
        }
    }

   
    public ArrayList<String> generateScenarios(Node startNode, int i)
    {
        String scenario = "";
        Node cNode = startNode.getTrue_part();
        Stack<Node> newStack = new Stack<Node>();
        Stack<String> scenarioStack = new Stack<String>();
        ArrayList<String> scenarioList = new ArrayList<String>();
       
        while(true)
        {
            switch(cNode.getType())
            {
                case 1: scenario = scenario+ cNode.getNode_no()+",";
                        cNode = cNode.getTrue_part();
                        break;
                case 2: scenarioStack.push(scenario + cNode.getNode_no() +"(F),");
                        scenario = scenario+ cNode.getNode_no()+"(T),";
                        newStack.push(cNode);
                        cNode = cNode.getTrue_part();
                        break;
                case 5:   
                       
                        if(newStack.search(cNode) == -1)            //Node not there
                        {
                            scenarioStack.push(scenario + cNode.getNode_no() +"(F),");
                            newStack.push(cNode);
                            scenario = scenario+ cNode.getNode_no()+"(T),";
                            cNode = cNode.getTrue_part();
                        }
                        else if(i > 1)
                        {
                            scenario = scenario+ cNode.getNode_no()+"(T),";
                            cNode = cNode.getTrue_part();
                            i--;
                        }
                        else
                        {
                            scenario = scenario+ cNode.getNode_no()+"(F),";
                            cNode = cNode.getElse_part();
                                   
                        }
                        break;
                case 3:
                case 4:
                case 6:    cNode = cNode.getTrue_part();
                        break;
                case 7: scenarioList.add(scenario);
                        if(scenarioStack.isEmpty())
                        return scenarioList;
                        else
                        {
                            scenario = scenarioStack.pop();
                            Node temp = newStack.pop();
                            cNode = temp.getElse_part();
                        }
            }
        }
    }
    public ArrayList<String> generateScenarios2(Node startNode, ArrayList<Integer> lpkount, ArrayList<Integer> whileSet)
    {
        String scenario = "";
        int temp2 = -1;
        Node cNode = startNode.getTrue_part();
        Stack<Node> newStack = new Stack<Node>();
        Stack<String> scenarioStack = new Stack<String>();
        ArrayList<String> scenarioList = new ArrayList<String>();
        Stack<Integer> iflist = new Stack<Integer>();
        Stack<Integer> indexlist = new Stack<Integer>();
        while(true)
        {
            switch(cNode.getType())
            {
                case 1: scenario = scenario+ cNode.getNode_no()+",";
                        cNode = cNode.getTrue_part();
                        break;
                case 2: scenarioStack.push(scenario + cNode.getNode_no() +"(F),");
                        if (temp2!=-1){
                            iflist.push(lpkount.get(temp2));
                            indexlist.push(temp2);
                        }
                        scenario = scenario+ cNode.getNode_no()+"(T),";
                        newStack.push(cNode);
                        cNode = cNode.getTrue_part();
                        break;
                case 5:   
                        int i = whileSet.indexOf(cNode.getNode_no());
                        temp2 = i;
                        if(newStack.search(cNode) == -1)            //Node not there
                        {
                            scenarioStack.push(scenario + cNode.getNode_no() +"(F),");
                            newStack.push(cNode);
                            scenario = scenario+ cNode.getNode_no()+"(T),";
                            cNode = cNode.getTrue_part();
                        }
                        else if(lpkount.get(i) > 1)
                        {
                            scenario = scenario+ cNode.getNode_no()+"(T),";
                            cNode = cNode.getTrue_part();
                            lpkount.set(i, (lpkount.get(i)-1));
                        }
                        else
                        {
                            scenario = scenario+ cNode.getNode_no()+"(F),";
                            cNode = cNode.getElse_part();
                                   
                        }
                        break;
                case 3:
                case 4:
                case 6:    cNode = cNode.getTrue_part();
                        break;
                case 7: scenarioList.add(scenario);
                        if(scenarioStack.isEmpty())
                        return scenarioList;
                        else
                        {
                            scenario = scenarioStack.pop();
                            Node temp = newStack.pop();
                            cNode = temp.getElse_part();
                            if(!indexlist.isEmpty())
                                lpkount.set(indexlist.pop(), iflist.pop());
                           
                        }
            }
        }
    }
}