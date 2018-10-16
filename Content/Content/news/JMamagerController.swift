//
//  JMamagerController.swift
//  Content
//
//  Created by fcn on 2018/10/11.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import MJRefresh
import Alamofire
import SwiftyJSON
import Kingfisher


let staticURL = "http://localhost:8080/"


class JMamagerController: UITableViewController {
    
    
    var datas = [JSON]()
    var pageNo: Int = 1
    

    override func viewDidLoad() {
        super.viewDidLoad()

        tableView.rowHeight = 240

        
        
        tableView.mj_footer = MJRefreshAutoNormalFooter(refreshingTarget: self, refreshingAction: #selector(loadMore))
        
        let m_parameters: Parameters = [
            "pageNo": pageNo,
            "pageSize": 10
        ]
        NetTool.Get(url: "\(BACKURL)getJman.action", parameters: m_parameters) { (json) in
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
        NetTool.Get(url: "\(BACKURL)getJman.action", parameters: m_parameters) { (json) in
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
        let cell = tableView.dequeueReusableCell(withIdentifier: "JMamagerCell", for: indexPath) as! JMamagerCell

        // Configure the cell...
        
        let json = datas[indexPath.row]
        
        
        
       let picurl = "\(staticURL)\(json["picurl"].stringValue)"
        
        cell.img.kf.setImage(with: ImageResource(downloadURL: URL(string: picurl)!))

    
        return cell
    }
    
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        //        print("didSelectRowAt")
        
        
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "JMamagerDetailController") as! JMamagerDetailController
        vc.model = datas[indexPath.row]
        self.navigationController?.pushViewController(vc, animated: true)
        
        
    }

    
}
