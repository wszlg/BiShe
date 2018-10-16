//
//  NewsViewController.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//


// 只有 文字和图片


import UIKit
import MJRefresh
import Alamofire
import SwiftyJSON
import Kingfisher

class MyCollectController: UITableViewController {
    
    
    var datas = [JSON]()
    var pageNo: Int = 1
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        self.title = "我的收藏"
        
        
        //        tableView.rowHeight = 100
        
        
        tableView.estimatedRowHeight = 100
//        tableView.mj_footer = MJRefreshAutoNormalFooter(refreshingTarget: self, refreshingAction: #selector(loadMore))
        
        tableView.mj_header = MJRefreshNormalHeader(refreshingTarget: self, refreshingAction: #selector(getnew))
        
        
        let m_parameters: Parameters = [
            "userid": DataTool.getInfo(key: "userid") as! String
        ]
        self.datas.removeAll()
        NetTool.Get(url: "\(BACKURL)getCollect.action", parameters: m_parameters) { (json) in
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
    
    @objc func getnew()  {
        
        self.datas.removeAll()
        let m_parameters: Parameters = [
            "userid": DataTool.getInfo(key: "userid") as! String
        ]
        NetTool.Get(url: "\(BACKURL)getCollect.action", parameters: m_parameters) { (json) in
            if let json = json {
                print(json)
                let data = json["list"].arrayValue
                for item in data {
                    self.datas.append(item)
                }
                self.tableView.reloadData()
                self.tableView.mj_header.endRefreshing()
            }
        }
        
    }
    
    
    @objc func loadMore()  {
//        pageNo += 1
//        let m_parameters: Parameters = [
//            "pageNo": pageNo,
//            "pageSize": 10
//        ]
//        NetTool.Get(url: "\(BACKURL)getRecommand.action", parameters: m_parameters) { (json) in
//            if let json = json {
//                let data = json["list"].arrayValue
//                for item in data {
//                    self.datas.append(item)
//                }
//                self.tableView.reloadData()
//                self.tableView.mj_footer.endRefreshing()
//            }
//        }
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
        
        
        let json = datas[indexPath.row]
        
        let type = json["type"].stringValue
        
        if type == "0" {
            let cell = tableView.dequeueReusableCell(withIdentifier: "NewsCell", for: indexPath) as! NewsCell
            cell.model = datas[indexPath.row]
            return cell
        } else if type == "1" {
            let cell = tableView.dequeueReusableCell(withIdentifier: "TextCell", for: indexPath) as! TextCell
            let json = datas[indexPath.row]
            cell.textinfo.text = json["title"].stringValue
            return cell
        } else if type == "2" {
            let cell = tableView.dequeueReusableCell(withIdentifier: "PicCell", for: indexPath) as! PicCell
            let json = datas[indexPath.row]
            cell.labelInfo.text = json["title"].stringValue
            cell.img.kf.setImage(with: ImageResource(downloadURL: URL(string: json["picurl"].stringValue)!))
            return cell
        } else if type == "3" {
            let cell = tableView.dequeueReusableCell(withIdentifier: "JMamagerCell", for: indexPath) as! JMamagerCell
            let json = datas[indexPath.row]
            let picurl = "\(staticURL)\(json["picurl"].stringValue)"
            cell.img.kf.setImage(with: ImageResource(downloadURL: URL(string: picurl)!))
            return cell
        }
        
        return UITableViewCell()
        
    }
    
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        let json = datas[indexPath.row]
        
        let type = json["type"].stringValue
        
        if type == "0" {
            return 100
        } else if type == "1" {
            return UITableViewAutomaticDimension
        } else if type == "2" {
            return UITableViewAutomaticDimension
        } else if type == "3" {
            return 240
        }
        
        return 0
    }
    
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        //        print("didSelectRowAt")
        
        
        let json = datas[indexPath.row]
        let type = json["type"].stringValue
        
        
        if type == "0" {
            let storyboard = UIStoryboard(name: "Main", bundle: nil)
            let vc = storyboard.instantiateViewController(withIdentifier: "NewsDetailViewController") as! NewsDetailViewController
            vc.model = datas[indexPath.row]
            self.navigationController?.pushViewController(vc, animated: true)
        } else if type == "1" {
            let storyboard = UIStoryboard(name: "Main", bundle: nil)
            let vc = storyboard.instantiateViewController(withIdentifier: "TextDetailController") as! TextDetailController
            vc.model = datas[indexPath.row]
            self.navigationController?.pushViewController(vc, animated: true)
        } else if type == "2" {
            let storyboard = UIStoryboard(name: "Main", bundle: nil)
            let vc = storyboard.instantiateViewController(withIdentifier: "PicDetailController") as! PicDetailController
            vc.model = datas[indexPath.row]
            self.navigationController?.pushViewController(vc, animated: true)
        } else if type == "3" {
            let storyboard = UIStoryboard(name: "Main", bundle: nil)
            let vc = storyboard.instantiateViewController(withIdentifier: "JMamagerDetailController") as! JMamagerDetailController
            vc.model = datas[indexPath.row]
            self.navigationController?.pushViewController(vc, animated: true)
        }
        
    }
    
    
    
    
    
}
