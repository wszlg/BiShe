//
//  CommentCell.swift
//  Content
//
//  Created by fcn on 2018/10/10.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit

class CommentCell: UITableViewCell {
    
    
    @IBOutlet weak var icon: UIImageView!
    @IBOutlet weak var name: UILabel!
    @IBOutlet weak var comment: UILabel!
    @IBOutlet weak var datetime: UILabel!
    
    

    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        
        icon.layer.cornerRadius = 30
        icon.layer.masksToBounds = true
        
        icon.image = UIImage(named: "test1")
        
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
