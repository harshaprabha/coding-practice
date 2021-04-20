package lld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class FileSystem {

  public static void main(String[] args) {
    FileSystem fs = new FileSystem();
    fs.ls("/");
    fs.mkdir("/a/b/c");
    fs.addContentToFile("/a/b/c/d", "hello");
    System.out.println(fs.ls("/"));
    System.out.println(fs.readContentFromFile("a/b/c/d"));
    fs.addContentToFile("/a/b/c/d", " harsha");
    System.out.println(fs.readContentFromFile("a/b/c/d"));

    fs.addContentToFile("/a/x", " xxx");
    System.out.println(fs.ls("/a/x"));
    System.out.println(fs.readContentFromFile("/a/x"));

  }


  Node root;

  enum NodeType {
    FILE, DIRECTORY;
  }

  class Node {

    String name;
    NodeType type;
    String content;// if FILE
    TreeMap<String, Node> nodes;

    public Node(String name, NodeType type, String content) {
      this.name = name;
      this.type = type;
      if (type == NodeType.DIRECTORY) {
        content = "";
        nodes = new TreeMap<>();
      } else {
        nodes = null;
        this.content = content;
      }
    }
  }

  public FileSystem() {
    root = new Node("/", NodeType.DIRECTORY, "");
  }

  public List<String> ls(String path) {

    String[] paths = path.split("/");
    List<String> res = new ArrayList<>();

    Node curr = root;
    int i = 0;

    while (curr != null && i < paths.length) {
      String name = paths[i++];
      if (name.isEmpty()) {
        continue;
      }
      curr = curr.nodes.get(name);
    }

    if (curr != null && curr.type == NodeType.FILE) // then its file
    {
      res.add(curr.name);
      return res;
    }
    for (Map.Entry<String, Node> entry : curr.nodes.entrySet()) {
      res.add(entry.getValue().name);
    }

    return res;
  }

  public void mkdir(String path) {
    String[] paths = path.split("/");
    Node curr = root;
    int i = 0;

    while (curr != null && i < paths.length) {
      String name = paths[i++];
      if (name.isEmpty()) {
        continue;
      }

      if (!curr.nodes.containsKey(name)) {
        // mkdir
        Node newNode = new Node(name, NodeType.DIRECTORY, "");
        curr.nodes.put(name, newNode);
        curr = newNode;
      } else {
        curr = curr.nodes.get(name);
      }
    }

  }

  public void addContentToFile(String filePath, String content) {

    String[] paths = filePath.split("/");
    Node curr = root;
    int i = 0;

    while (curr != null && i < paths.length) {

      String name = paths[i++];
      if (name.isEmpty()) {
        continue;
      }
      if (!curr.nodes.containsKey(name)) {
        Node newNode = new Node(name, NodeType.FILE, content);
        curr.nodes.put(name, newNode);
        curr = newNode;
        return;
      } else {
        curr = curr.nodes.get(name);
      }
    }

    if (curr != null) {
      curr.content = curr.content + content;
    }

  }


  public String readContentFromFile(String filePath) {
    String[] paths = filePath.split("/");
    Node curr = root;
    int i = 0;

    while (curr != null && i < paths.length) {
      String name = paths[i++];
      if (name.isEmpty()) {
        continue;
      }
      curr = curr.nodes.get(name);
    }
    return curr == null ? "" : curr.content;

  }
}