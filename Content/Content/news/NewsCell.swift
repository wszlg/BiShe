//
//  NewsCell.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import SwiftyJSON
import Kingfisher



class NewsCell: UITableViewCell {

    @IBOutlet weak var title: UILabel!
    @IBOutlet weak var img: UIImageView!
    @IBOutlet weak var collectCount: UILabel!
    
    
    
    
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    
    var model: JSON! {
        
        didSet {
            title.text = model["title"].stringValue
            if let count = model["collectCount"].int {
                collectCount.text = "\(count)收藏"
            } else {
                
            }
            img.kf.setImage(with: ImageResource(downloadURL: URL(string: model["picurl"].stringValue)!))
            
        }
    }
    

}
