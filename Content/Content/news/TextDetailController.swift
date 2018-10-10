//
//  TextDetailController.swift
//  Content
//
//  Created by fcn on 2018/10/10.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import SwiftyJSON
import Kingfisher



class TextDetailController: UITableViewController, UITextFieldDelegate {
    
    
    @IBOutlet weak var commentText: UITextField!
    
    
    
    var model: JSON!
    
    var datas = [Comment]()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        commentText.delegate = self
        
        
        tableView.register(UINib(nibName: "CommentCell", bundle: nil), forCellReuseIdentifier: "CommentCell")
        
        tableView.estimatedRowHeight = 100
        
        tableView.rowHeight = UITableViewAutomaticDimension
        
        reloadDatas()
        
    }
    
    
    func reloadDatas()  {
        self.datas.removeAll()
        let newid = model["id"].stringValue
        DataTool.searchValueByBlock(type: Comment.self, condition: "newsid == '\(newid)'") { (result) in
            if let r = result {
                for item in r {
                    self.datas.append(item)
                }
                self.tableView.reloadData()
            }
        }
    }



    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 2
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        if section == 0 {
            return 1
        }
        return datas.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if indexPath.section == 0 {
            let cell = tableView.dequeueReusableCell(withIdentifier: "TextDetailCell", for: indexPath) as! TextDetailCell
            cell.title.text = model["title"].stringValue
            cell.content.text = model["content"].stringValue
            return cell
        } else {
            let cell = tableView.dequeueReusableCell(withIdentifier: "CommentCell", for: indexPath) as! CommentCell
            cell.name.text = datas[indexPath.row].username
            cell.comment.text = datas[indexPath.row].comment
            cell.datetime.text = datas[indexPath.row].datetime
            return cell
        }
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        
        let comment = Comment()
        comment.id = DataTool.getUUID()
        comment.comment = textField.text!
        comment.userid = "sdd"
        comment.newsid = model["id"].stringValue
        comment.username = "sdfdsfdd"
        comment.datetime = DataTool.getCurrentTime()
        
        DataTool.addValue(values: comment)
        
        textField.resignFirstResponder()
        textField.text = ""
        reloadDatas()
        return true
    }
    

}
