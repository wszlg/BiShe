//
//  PicController.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//  人文

import UIKit
import MJRefresh
import Alamofire
import SwiftyJSON
import Kingfisher

class PicController: UITableViewController {
    
    var datas = [JSON]()
    var pageNo: Int = 1
    

    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        tableView.estimatedRowHeight = 100
        tableView.rowHeight = UITableViewAutomaticDimension
        
        
        tableView.mj_footer = MJRefreshAutoNormalFooter(refreshingTarget: self, refreshingAction: #selector(loadMore))
        
        let m_parameters: Parameters = [
            "pageNo": pageNo,
            "pageSize": 10
        ]
        NetTool.Get(url: "http://localhost:8080/api/user/getHum.action", parameters: m_parameters) { (json) in
            if let json = json {
                print(json)
                let data = json["list"].arrayValue
                for item in data {
                    self.datas.append(item)
                }
                self.tableView.reloadData()
            }
        }
    }
    
    
    @objc func loadMore()  {
        pageNo += 1
        let m_parameters: Parameters = [
            "pageNo": pageNo,
            "pageSize": 10
        ]
        NetTool.Get(url: "http://localhost:8080/api/user/getHum.action", parameters: m_parameters) { (json) in
            if let json = json {
                let data = json["list"].arrayValue
                for item in data {
                    self.datas.append(item)
                }
                self.tableView.reloadData()
                self.tableView.mj_footer.endRefreshing()
            }
        }
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return datas.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "PicCell", for: indexPath) as! PicCell
        
        let json = datas[indexPath.row]
        
        cell.labelInfo.text = json["title"].stringValue
        
        cell.img.kf.setImage(with: ImageResource(downloadURL: URL(string: json["picurl"].stringValue)!))
        
        return cell
    }

    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "PicDetailController") as! PicDetailController
        vc.model = datas[indexPath.row]
        self.navigationController?.pushViewController(vc, animated: true)
    }


}
