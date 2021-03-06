//
//  ChatsController.swift
//  Content
//
//  Created by fcn on 2018/10/23.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import SwiftyJSON
import MJRefresh

class ChatsController: UITableViewController {
    
    var datas = [JSON]()
    
    var dataModels = [ChatModel]()
    

    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        self.navigationItem.title = "话题讨论"
        
        tableView.estimatedRowHeight = 100
        tableView.rowHeight = UITableViewAutomaticDimension
        
        tableView.mj_header = MJRefreshNormalHeader(refreshingTarget: self, refreshingAction: #selector(getnew))
        
        NetTool.Get(url: "\(BACKURL)getChats.action", parameters: nil) { (json) in
            if let js = json {
                if js["status"].intValue == 1 {
                    self.datas = js["list"].arrayValue
                    self.dataModels.removeAll()
                    for var item in self.datas {
                        let coutn = DataTool.searchValueCount(type: Comment.self, condition: "newsid == '\(item["id"].stringValue)'")
                        self.dataModels.append(ChatModel(content: item["content"].stringValue, chatCount: coutn))
                    }
                    
                    
                    self.tableView.reloadData()
                }
            }
    }
    

    }
    
    @objc func getnew()  {
        NetTool.Get(url: "\(BACKURL)getChats.action", parameters: nil) { (json) in
            if let js = json {
                if js["status"].intValue == 1 {
                    self.datas = js["list"].arrayValue
                    self.dataModels.removeAll()
                    for var item in self.datas {
                        let coutn = DataTool.searchValueCount(type: Comment.self, condition: "newsid == '\(item["id"].stringValue)'")
                        self.dataModels.append(ChatModel(content: item["content"].stringValue, chatCount: coutn))
                    }
                    
                    
                    self.tableView.reloadData()
                }
            }
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return dataModels.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ChatsCell", for: indexPath) as! ChatsCell

        // Configure the cell...
        cell.content.text = dataModels[indexPath.row].content
        cell.chatCount.text = "\(dataModels[indexPath.row].chatCount)人参与讨论"
        

        return cell
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "ChatDetailController") as! ChatDetailController
        vc.model = self.datas[indexPath.row]
        navigationController?.pushViewController(vc, animated: true)
        
    }

   

}
